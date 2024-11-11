package com.example.onlineticketing.comms.helper;

public class EnumHelperUtil {
    public static <T extends Enum<T>> T getEnumFromString(Class<T> enumClass, String value) {
        return Enum.valueOf(enumClass, value);
    }
}
