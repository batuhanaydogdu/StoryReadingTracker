package com.impostors.app.ws.storyreadingtrackerws.shared.dto;

import java.io.Serializable;
import java.util.Collection;

public class UserDto implements Serializable {


    private static final long serialVersionUID=4865903039190150223l;
    private long id;
    private String userId;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private int points;
    private boolean termsAndPoliciesAccepted;
    private String email;
    private String password;
    private String encryptedPassword;
    private String emailVerificationToken;
    private Boolean emailVerificationStatus;
    private Collection<String> roles;
    private String chosenAvatarUrl;


    public UserDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public String getEmailVerificationToken() {
        return emailVerificationToken;
    }

    public void setEmailVerificationToken(String emailVerificationToken) {
        this.emailVerificationToken = emailVerificationToken;
    }

    public Boolean getEmailVerificationStatus() {
        return emailVerificationStatus;
    }

    public void setEmailVerificationStatus(Boolean emailVerificationStatus) {
        this.emailVerificationStatus = emailVerificationStatus;
    }

    public Collection<String> getRoles() {
        return roles;
    }

    public void setRoles(Collection<String> roles) {
        this.roles = roles;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public boolean isTermsAndPoliciesAccepted() {
        return termsAndPoliciesAccepted;
    }

    public void setTermsAndPoliciesAccepted(boolean termsAndPoliciesAccepted) {
        this.termsAndPoliciesAccepted = termsAndPoliciesAccepted;
    }

    public String getChosenAvatarUrl() {
        return chosenAvatarUrl;
    }

    public void setChosenAvatarUrl(String chosenAvatarUrl) {
        this.chosenAvatarUrl = chosenAvatarUrl;
    }
}
