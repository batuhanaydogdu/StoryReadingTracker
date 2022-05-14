package com.impostors.app.ws.storyreadingtrackerws.shared.dto;

import com.impostors.app.ws.storyreadingtrackerws.io.document.Contour;

import java.util.Date;
import java.util.List;

public class FaceExperienceDto {
    private String faceExperienceDocumentId;
    private String userId;
    private String storyId;
    private List<Contour> Points;
    private Date readingDate;


    public String getFaceExperienceDocumentId() {
        return faceExperienceDocumentId;
    }

    public void setFaceExperienceDocumentId(String faceExperienceDocumentId) {
        this.faceExperienceDocumentId = faceExperienceDocumentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStoryId() {
        return storyId;
    }

    public void setStoryId(String storyId) {
        this.storyId = storyId;
    }

    public List<Contour> getPoints() {
        return Points;
    }

    public void setPoints(List<Contour> points) {
        Points = points;
    }

    public Date getReadingDate() {
        return readingDate;
    }

    public void setReadingDate(Date readingDate) {
        this.readingDate = readingDate;
    }
}
