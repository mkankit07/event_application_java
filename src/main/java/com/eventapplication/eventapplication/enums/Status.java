package com.eventapplication.eventapplication.enums;

public enum Status {
    DELETED(0),
    ACTIVE(1),
    INACTIVE(2);
    private final int val;
    Status(int val){
        this.val=val;
    }
    public int getValue(){
        return this.val;
    }
}
