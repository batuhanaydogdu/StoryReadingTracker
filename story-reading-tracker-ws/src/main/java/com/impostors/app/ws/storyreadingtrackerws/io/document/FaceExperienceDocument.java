package com.impostors.app.ws.storyreadingtrackerws.io.document;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.awt.geom.Point2D;
import java.util.Date;
import java.util.List;

@Document(collection = "faceExperience")
public class FaceExperienceDocument {

    @Id  //data.annotation.Id  don't forget
    private String faceExperienceDocumentId;
    private String userId;
    private String storyId;
    private List<Contour> Points;
    private List<WordMicrophone> words;
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

    public List<WordMicrophone> getWords() {
        return words;
    }

    public void setWords(List<WordMicrophone> words) {
        this.words = words;
    }
}