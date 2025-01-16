package com.xworkz.gym.constants;

public enum StatusEnum {
    Enquired, FollowedUp;

    @Override
    public String toString() {
        return this.name();  // This will return the name of the enum value as a string.
    }
}

