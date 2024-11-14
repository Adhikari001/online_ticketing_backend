package com.example.onlineticketing.comms.helper;

import com.example.onlineticketing.comms.exceptionhandler.RestException;
import com.example.onlineticketing.constant.enums.Gender;

public class EnumHelperUtil {
    public static <T extends Enum<T>> T getEnumFromString(Class<T> enumClass, String value) {
        return Enum.valueOf(enumClass, value);
    }

    public static Gender validateGender(String gender) {
        for (Gender genderEnum : Gender.values()) {
            if (genderEnum.name().equalsIgnoreCase(gender))
                return genderEnum;
        }
        throw new RestException("PS004", "Gender can be MALE, FEMALE, OTHERS");
    }
}
