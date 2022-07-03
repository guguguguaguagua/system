package com.bean;

public class Admin extends User{
    private String AdminNumber;
    private String AdminPassword;
    private String AdminName;

    public String getAdminNumber() {
        return AdminNumber;
    }

    public void setAdminNumber(String adminNumber) {
        this.AdminNumber = adminNumber;
    }

    public String getAdminPassword() {
        return AdminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.AdminPassword = adminPassword;
    }

    public String getAdminName() {
        return AdminName;
    }

    public void setAdminName(String adminName) {
        this.AdminName = adminName;
    }
}
