package com.eventapplication.eventapplication.common;

public enum ConstantMessage {
    USER_CREATED("User created successfully"),
    USER_CONFLICT("User already exist"),
    USER_FOUND("User found"),
    USER_NOT_FOUND("User not found"),
    BAD_REQUEST("bad request"),
    STUDENT_DETAIL_ADDED("Student details added successfully"),
    ADDRESS_ADDED("User added successfully"),
    STUDENT_CONFLICT("student details already exist"),
    INVALID_USER_DETAILS("Invalid email or password"),
    LOGIN_SUCCESSFULLY("login successfully");
    private final String value;
    ConstantMessage(String msg){
        this.value=msg;
    }
    public String getValue(){
        return this.value;
    }
}
