package com.impostors.app.ws.storyreadingtrackerws.io.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity()
@Table(name="stories")
public class StoryEntity implements Serializable {

    private static final long serialVersionUID = -76854760916660252L;
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable=false)
    private String storyId;

    @Column(nullable=false)
    private String storyText;

    @Column(nullable=false)
    private String title;

    @Column(nullable=false)
    private Date createdOn;

    @Column(nullable=false)
    private Date updatedOn;

    @Column(nullable=false)
    private String updatedBy;

    @OneToMany(mappedBy = "storyDetails",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)//
    private Collection<StoryUserEntity> storiesUsers;

    @OneToMany(mappedBy = "storyDetails",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)//
    private Collection<FeedbackEntity> feedbacks;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStoryId() {
        return storyId;
    }

    public void setStoryId(String storyId) {
        this.storyId = storyId;
    }

    public String getStoryText() {
        return storyText;
    }

    public void setStoryText(String storyText) {
        this.storyText = storyText;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Collection<StoryUserEntity> getStoriesUsers() {
        return storiesUsers;
    }

    public void setStoriesUsers(Collection<StoryUserEntity> storiesUsers) {
        this.storiesUsers = storiesUsers;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Collection<FeedbackEntity> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(Collection<FeedbackEntity> feedbacks) {
        this.feedbacks = feedbacks;
    }
}
