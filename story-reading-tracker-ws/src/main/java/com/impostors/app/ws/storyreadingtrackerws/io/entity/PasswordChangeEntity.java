package com.impostors.app.ws.storyreadingtrackerws.io.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name="passwordChanges")
public class PasswordChangeEntity implements Serializable {

    private static final long serialVersionUID = -76854760916660252L;
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable=false,length = 50)
    private String code;

    @Column(nullable=false)
    private Date validUntil;

    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name="users_id")
    private UserEntity userDetails;


/*
    @ManyToMany(mappedBy = "passwordChanges")
    private Collection<UserEntity> users;
*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }

    public UserEntity getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserEntity userDetails) {
        this.userDetails = userDetails;
    }
}
