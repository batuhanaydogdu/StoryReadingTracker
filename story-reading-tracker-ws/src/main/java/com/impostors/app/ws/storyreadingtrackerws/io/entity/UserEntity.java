package com.impostors.app.ws.storyreadingtrackerws.io.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity(name="users")
public class UserEntity implements Serializable {

    private static final long serialVersionUID = -76854760916660252L;
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable=false)
    private String userId;

    @Column(nullable=false,length = 50)
    private String firstName;

    @Column(nullable=false,length = 50)
    private String lastName;

    @Column(nullable=false,length = 50)
    private int age;

    @Column(nullable=false,length = 50)
    private String gender;

    @Column(nullable=false,length = 50)
    private int points;

    @Column(nullable=false,columnDefinition = "boolean default false")
    private boolean termsAndPoliciesAccepted;

    @Column(nullable=false,length = 120,unique = true)
    private String email;

    @Column(nullable=false)
    private String encryptedPassword;

    private String emailVerificationToken;

    @Column(nullable=false,columnDefinition = "boolean default false")
    private Boolean emailVerificationStatus;

    @ManyToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER )
    @JoinTable(name="users_roles",
            joinColumns = @JoinColumn(name="users_id",referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="roles_id",referencedColumnName="id") )
    private Collection<RoleEntity> roles;

    @OneToMany(mappedBy = "userDetails",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)//
    private Collection<StoryUserEntity> storiesUsers;

    @OneToMany(mappedBy = "userDetails",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)//
    private Collection<FeedbackEntity> feedbacks;

    @ManyToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER )
    @JoinTable(name="users_avatars",
            joinColumns =  @JoinColumn(name="users_id", updatable = true,referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="avatars_id", updatable = true,referencedColumnName="id") )
    private Set<AvatarEntity> avatars;

    @OneToMany(mappedBy = "userDetails",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    private Collection<PasswordChangeEntity> passwordChanges;
/*
    @ManyToMany(cascade = {CascadeType.PERSIST} )
    @JoinTable(name="users_password_changes",
            joinColumns = @JoinColumn(name="users_id",referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="password_changes_id",referencedColumnName="id") )
    private Collection<PasswordChangeEntity> passwordChanges;

*/




    public Set<AvatarEntity> getAvatars() {
        return avatars;
    }

    public void setAvatars(Set<AvatarEntity> avatars) {
        this.avatars = avatars;
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

    public Collection<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Collection<RoleEntity> roles) {
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

    public boolean getTermsAndPoliciesAccepted() {
        return termsAndPoliciesAccepted;
    }

    public void setTermsAndPoliciesAccepted(boolean termsAndPoliciesAccepted) {
        this.termsAndPoliciesAccepted = termsAndPoliciesAccepted;
    }

    public Collection<StoryUserEntity> getStoriesUsers() {
        return storiesUsers;
    }

    public void setStoriesUsers(Collection<StoryUserEntity> storiesUsers) {
        this.storiesUsers = storiesUsers;
    }

    public Collection<FeedbackEntity> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(Collection<FeedbackEntity> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public Collection<PasswordChangeEntity> getPasswordChanges() {
        return passwordChanges;
    }

    public void setPasswordChanges(Collection<PasswordChangeEntity> passwordChanges) {
        this.passwordChanges = passwordChanges;
    }
}
