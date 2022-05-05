package com.impostors.app.ws.storyreadingtrackerws.io.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "feedbacks")
public class FeedbackEntity implements Serializable {

    private static final long serialVersionUID = -5264726824009902831L;
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable=false)
    private String feedbackId;

    @Column(nullable=false)
    private String feedbackText;

    @Column(nullable=false)
    private boolean feedbackRead;

    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name="users_id")
    private UserEntity userDetails;

    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name="stories_id")
    private StoryEntity storyDetails;

    @Column(nullable=false)
    private Date createdOn;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(String feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }

    public boolean isFeedbackRead() {
        return feedbackRead;
    }

    public void setFeedbackRead(boolean feedbackRead) {
        this.feedbackRead = feedbackRead;
    }

    public UserEntity getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserEntity userDetails) {
        this.userDetails = userDetails;
    }

    public StoryEntity getStoryDetails() {
        return storyDetails;
    }

    public void setStoryDetails(StoryEntity storyDetails) {
        this.storyDetails = storyDetails;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}
