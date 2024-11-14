package com.example.onlineticketing.service.person;

import java.security.Principal;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.example.onlineticketing.dto.person.AddPersonRequest;
import com.example.onlineticketing.dto.person.AuthenticateRequest;
import com.example.onlineticketing.dto.person.AuthenticationResponse;
import com.example.onlineticketing.dto.person.UpdatePasswordRequest;
import com.example.onlineticketing.dto.person.UpdatePersonRequest;
import com.example.onlineticketing.dto.person.UserInformation;
import com.example.onlineticketing.dto.person.UserInformationResponse;
import com.example.onlineticketing.dto.util.MessageResponse;
import com.example.onlineticketing.dto.util.ValueLabelDropdown;

public interface PersonService {

    UserDetails getUserDetails(String username);

    AuthenticationResponse authenticateUser(AuthenticateRequest request);

    UserInformation getAuthenticatedUser(Principal principal);

    List<UserInformation> getAllPerson();

    List<ValueLabelDropdown> getDoctorDropdown();

    MessageResponse addPerson(AddPersonRequest request);

    MessageResponse updatePerson(UpdatePersonRequest request, Long userId);

    UserInformation getPersonDetail(Long userId);

    MessageResponse changePassword(UpdatePasswordRequest request);

}
