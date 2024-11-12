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
import com.example.onlineticketing.dto.person.AddPersonRequest;
import com.example.onlineticketing.dto.person.AuthenticateRequest;
import com.example.onlineticketing.dto.person.AuthenticationResponse;
import com.example.onlineticketing.dto.person.UpdatePasswordRequest;
import com.example.onlineticketing.dto.person.UpdatePersonRequest;
import com.example.onlineticketing.dto.person.UserInformation;
import com.example.onlineticketing.dto.person.UserInformationResponse;
import com.example.onlineticketing.dto.util.MessageResponse;
import com.example.onlineticketing.dto.util.ValueLabelDropdown;
import com.example.onlineticketing.entity.person.Person;
import com.example.onlineticketing.repository.PersonRepository;
import com.example.onlineticketing.service.jwt.TokenService;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;

    public PersonServiceImpl(PersonRepository personRepository, AuthenticationManager authenticationManager,
            TokenService tokenService, PasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.passwordEncoder = passwordEncoder;
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAuthenticatedUser'");
    }

    @Override
    public List<UserInformation> getAllPerson() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllPerson'");
    }

    @Override
    public List<ValueLabelDropdown> getDoctorDropdown() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDoctorDropdown'");
    }

    @Override
    public MessageResponse addPerson(AddPersonRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addPerson'");
    }

    @Override
    public MessageResponse updatePerson(UpdatePersonRequest request, String userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePerson'");
    }

    @Override
    public UserInformationResponse getPersonDetail(String userId, String from, String to, String testData) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPersonDetail'");
    }

    @Override
    public MessageResponse changePassword(UpdatePasswordRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changePassword'");
    }

}
