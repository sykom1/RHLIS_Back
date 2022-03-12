package com.amu.project_back.dto;

public class UtilisateursDTO {
    private Long utiId;
    private String utiLogin;
    private Integer utiPoids;
    private Byte utiBanni;
    private Long utiDroiId;
    private java.sql.Timestamp birthday;
    private String firstname;
    private String lastname;
    private String password;
    private String phoneNumber;
    private Integer role;
    private Long directoryAnnId;

    public Long getUtiId() {
        return this.utiId;
    }

    public void setUtiId(Long utiId) {
        this.utiId = utiId;
    }

    public String getUtiLogin() {
        return this.utiLogin;
    }

    public void setUtiLogin(String utiLogin) {
        this.utiLogin = utiLogin;
    }

    public Integer getUtiPoids() {
        return this.utiPoids;
    }

    public void setUtiPoids(Integer utiPoids) {
        this.utiPoids = utiPoids;
    }

    public Byte getUtiBanni() {
        return this.utiBanni;
    }

    public void setUtiBanni(Byte utiBanni) {
        this.utiBanni = utiBanni;
    }

    public Long getUtiDroiId() {
        return this.utiDroiId;
    }

    public void setUtiDroiId(Long utiDroiId) {
        this.utiDroiId = utiDroiId;
    }

    public java.sql.Timestamp getBirthday() {
        return this.birthday;
    }

    public void setBirthday(java.sql.Timestamp birthday) {
        this.birthday = birthday;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getRole() {
        return this.role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Long getDirectoryAnnId() {
        return this.directoryAnnId;
    }

    public void setDirectoryAnnId(Long directoryAnnId) {
        this.directoryAnnId = directoryAnnId;
    }
}
