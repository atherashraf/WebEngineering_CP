package org.pucit.org.pucit.enumerators;

public enum UserType {
    USER("Siter User", "user"),
    ADMIN("Admintrator", "admin");

    public String name;
    public String value;
    UserType(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
