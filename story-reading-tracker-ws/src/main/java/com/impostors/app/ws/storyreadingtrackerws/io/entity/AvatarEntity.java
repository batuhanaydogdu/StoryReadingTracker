package com.impostors.app.ws.storyreadingtrackerws.io.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "avatars")
public class AvatarEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @Column
    private String avatarId;
    @Column(nullable = false)
    private String avatarName;

    @Column(nullable = false)
    private int avatarPrice;

    @Column(nullable = false)
    private String avatarURL;

    @ManyToMany(mappedBy = "avatars")
    private Set<UserEntity> users;

    public String getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(String avatarId) {
        this.avatarId = avatarId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAvatarName() {
        return avatarName;
    }

    public void setAvatarName(String avatarName) {
        this.avatarName = avatarName;
    }

    public int getAvatarPrice() {
        return avatarPrice;
    }

    public void setAvatarPrice(int avatarPrice) {
        this.avatarPrice = avatarPrice;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }
}
