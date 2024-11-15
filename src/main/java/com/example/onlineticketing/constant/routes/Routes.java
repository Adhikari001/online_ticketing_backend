package com.example.onlineticketing.constant.routes;

public class Routes {

    public static final String BASE_URL = "/api/v1";


    // person
    public static final String PERSON = BASE_URL + "/person";
    public static final String GET_AUTHENTICATED_PERSON = PERSON + "/authenticated-person";
    public static final String GET_ALL_PERSON = PERSON + "/get-all";
    public static final String GET_DOCTOR_DROPDOWN = PERSON + "/doctor-dropdown";
    public static final String ADD_PERSON = PERSON + "/add";
    public static final String UPDATE_PERSON = PERSON + "/update/{userId}";
    public static final String DELETE_PERSON = PERSON + "/delete";
    public static final String GET_PERSON_BY_ID = PERSON + "/get-by-id/{userId}";
    public static final String PERSON_LOGOUT = PERSON + "/logout";
    public static final String CHANGE_PASSWORD = PERSON + "/change-password";

}
