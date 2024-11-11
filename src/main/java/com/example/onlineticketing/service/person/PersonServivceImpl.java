package com.example.onlineticketing.service.person;

import java.security.Principal;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.onlineticketing.dto.person.AddPersonRequest;
import com.example.onlineticketing.dto.person.AuthenticateRequest;
import com.example.onlineticketing.dto.person.AuthenticationResponse;
import com.example.onlineticketing.dto.person.UpdatePasswordRequest;
import com.example.onlineticketing.dto.person.UpdatePersonRequest;
import com.example.onlineticketing.dto.person.UserInformation;
import com.example.onlineticketing.dto.person.UserInformationResponse;
import com.example.onlineticketing.dto.util.MessageResponse;
import com.example.onlineticketing.dto.util.ValueLabelDropdown;

@Service
public class PersonServivceImpl implements PersonService {

    @Override
    public UserDetails getUserDetails(String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserDetails'");
    }

    @Override
    public AuthenticationResponse authenticateUser(AuthenticateRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'authenticateUser'");
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
