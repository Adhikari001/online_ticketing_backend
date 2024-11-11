package com.example.onlineticketing.comms.validator;


import com.example.onlineticketing.dto.person.AddPersonRequest;
import com.example.onlineticketing.dto.person.UpdatePasswordRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, Object> {

//    @Override
//    public void initialize(PasswordMatches constraintAnnotation) {
//    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        if (obj == null) return false;
        if (!(obj instanceof AddPersonRequest || obj instanceof UpdatePasswordRequest)) return false;

        if (obj instanceof AddPersonRequest user) {
            if (user.getPassword() == null) return false;
            return user.getPassword().equals(user.getConfirmPassword());
        }

        UpdatePasswordRequest request = (UpdatePasswordRequest) obj;
        if (request.getNewPassword() == null) return false;
        return request.getNewPassword().equals(request.getConfirmPassword());

    }
}