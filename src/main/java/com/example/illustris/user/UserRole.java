package com.example.illustris.user;

public enum UserRole{
    Admin,
    Medical,
    User;

    //Formats Role to fit Security Config
    public String roleFmt() {
        String role=super.toString().toUpperCase();
        role="ROLE_"+role;
        return role;
    }

    //Converts Role to Uppercase
    public String roleUpCase() {
        return super.toString().toUpperCase();
    }
}
