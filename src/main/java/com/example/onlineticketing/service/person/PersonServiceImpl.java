package com.example.onlineticketing.service.person;

import java.lang.module.ResolutionException;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.onlineticketing.comms.exceptionhandler.RestException;
import com.example.onlineticketing.comms.helper.EnumHelperUtil;
import com.example.onlineticketing.comms.helper.HelperUtil;
import com.example.onlineticketing.constant.enums.Gender;
import com.example.onlineticketing.dto.person.AddPersonRequest;
import com.example.onlineticketing.dto.person.AuthenticateRequest;
import com.example.onlineticketing.dto.person.AuthenticationResponse;
import com.example.onlineticketing.dto.person.UpdatePasswordRequest;
import com.example.onlineticketing.dto.person.UpdatePersonRequest;
import com.example.onlineticketing.dto.person.UserInformation;
import com.example.onlineticketing.dto.util.MessageResponse;
import com.example.onlineticketing.dto.util.ValueLabelDropdown;
import com.example.onlineticketing.entity.person.Person;
import com.example.onlineticketing.repository.PersonRepository;
import com.example.onlineticketing.service.jwt.TokenService;
import com.example.onlineticketing.service.role.RoleValidator;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;
    private final RoleValidator roleValidator;
    private final PersonValidator personValidator;

    public PersonServiceImpl(PersonRepository personRepository, AuthenticationManager authenticationManager,
            TokenService tokenService, PasswordEncoder passwordEncoder, RoleValidator roleValidator,
            PersonValidator personValidator) {
        this.personRepository = personRepository;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.passwordEncoder = passwordEncoder;
        this.roleValidator = roleValidator;
        this.personValidator = personValidator;
    }

    @Override
    public UserDetails getUserDetails(String username) {
        Person person = personRepository.findByUsername(username.toLowerCase()).orElseThrow(
                () -> new UsernameNotFoundException("Can not find person from the given username " + username));
        return new CustomUserDetailService(person);
    }

    @Override
    public AuthenticationResponse authenticateUser(AuthenticateRequest request) {
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername().toLowerCase(),
                            request.getPassword()));
        } catch (Exception e) {
            throw new RestException("AU001", "Can not authenticate user");
        }
        final String accessToken = tokenService.generateToken(authentication);
        Optional<Person> optionalPerson = personRepository.findByUsername(request.getUsername().toLowerCase());
        if (!optionalPerson.isPresent()) {
            throw new RestException("AU002", "Can not find user from the given token");
        }
        return AuthenticationResponse.builder().accessToken(accessToken)
                .userInformation(UserHelper.getUserInformation(optionalPerson.get())).build();
    }

    @Override
    public UserInformation getAuthenticatedUser(Principal principal) {
        if (principal == null) {
            throw new RestException("PS001", "Can not find user from the given username.");
        }
        Person person = personRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new RestException("PS002", "Can not find user from the given username"));
        return UserHelper.getUserInformation(person);
    }

    @Override
    public List<UserInformation> getAllPerson() {
        return personRepository.getAllUsers();
    }

    @Override
    public List<ValueLabelDropdown> getDoctorDropdown() {
        return personRepository.findAllDoctorDropdown();
    }

    @Override
    public MessageResponse addPerson(AddPersonRequest request) {
        validateEmailNotUsed(request.getEmail());
        Person person = prepareToAddUpdatePerson(new Person(), request);
        person.setHashedPassword(passwordEncoder.encode(request.getPassword()));
        personRepository.save(person);
        return new MessageResponse("Person added successfully.");
    }

    @Override
    public MessageResponse updatePerson(UpdatePersonRequest request, Long userId) {
        Person person = personValidator.validatePerson(userId);
        personRepository.save(prepareToAddUpdatePerson(person, request));
        return new MessageResponse("Person updated successfully.");
    }

    @Override
    public UserInformation getPersonDetail(Long userId) {
        Person person = personValidator.validatePerson(userId);
        return UserHelper.getUserInformation(person);
    }

    @Override
    public MessageResponse changePassword(UpdatePasswordRequest request) {
        Person person = personValidator.getLoggedInPerson();
        if (!passwordEncoder.matches(request.getOldPassword(), person.getHashedPassword())) {
            throw new RestException("PS005", "Old password is incorrect");
        }
        person.setHashedPassword(passwordEncoder.encode(request.getNewPassword()));
        personRepository.save(person);
        return new MessageResponse("Password changed successfully.");
    }

    private void validateEmailNotUsed(String email) {
        Optional<Person> person = personRepository.findByUsername(email.toLowerCase());
        if (person.isPresent()) {
            throw new RestException("PS003", "Person with this email already exists");
        }
    }

    private Person prepareToAddUpdatePerson(Person person, UpdatePersonRequest request) {
        if (person.getId() == null) {
            // add case
            person.setJoinedDate(HelperUtil.getLocalDateTimeOfUTC());
            person.setEmail(request.getEmail().toLowerCase());
            person.setUsername(request.getEmail().toLowerCase());
        } else {
            // update case
            person.setUpdatedDate(HelperUtil.getLocalDateTimeOfUTC());
        }
        person.setFirstName(request.getFirstName());
        person.setLastName(request.getLastName());
        person.setPhoneNumber(request.getPhoneNumber());
        // male , female, others
        person.setGender(EnumHelperUtil.validateGender(request.getGender()).name());
        person.setDoctor(request.getIsDoctor());
        person.setDeleted(false);
        person.setRole(roleValidator.validateRole(request.getRoleId()));
        person.setActive(request.getIsActive());
        return person;
    }

}
