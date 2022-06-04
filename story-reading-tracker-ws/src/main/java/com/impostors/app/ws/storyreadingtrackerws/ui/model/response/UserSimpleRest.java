package com.impostors.app.ws.storyreadingtrackerws.ui.model.response;

public class UserSimpleRest {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private String gender;
    private int points;
    private boolean termsAndPoliciesAccepted;
    private String chosenAvatarUrl;


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
