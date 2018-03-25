package com.playband.model;

import java.io.Serializable;

public enum UserRoleType implements Serializable {
    USER("USER"),
    ADMIN("ADMIN");

    String userProfileType;

    private UserRoleType(String userProfileType) {
        this.userProfileType = userProfileType;
    }

    public String getUserProfileType() {
        return userProfileType;
    }

}
