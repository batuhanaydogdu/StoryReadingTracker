package com.impostors.app.ws.storyreadingtrackerws.shared.dto;

import com.impostors.app.ws.storyreadingtrackerws.io.document.Point2;

import java.awt.geom.Point2D;
import java.util.List;

public class ContourDto {

    private List<Point2> faceOvalContour;
    private List<Point2> upperLipBottomContour ;
    private List<Point2> leftEyeContour ;
    private List<Point2> leftCheekContour;
    private List<Point2> leftEyebrowBotContour;
    private List<Point2> rightEyeContour;
    private List<Point2> leftEyebrowTopContour;
    private List<Point2> lowerLipBotContour;
    private List<Point2> lowerLipTopContour;
    private List<Point2> noseBotContour ;
    private List<Point2> noseBridgeContour ;
    private List<Point2> upperLipTopContour ;
    private List<Point2> rightCeekContour ;
    private List<Point2> rightEyebrowBotContour ;
    private List<Point2> rightEyebrowTopContour ;
    private float rotY ;
    private float rotZ;
    private long readingMilisecond;
    private int centerX;
    private int centerY;


    public int getCenterX() {
        return centerX;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public List<Point2> getFaceOvalContour() {
        return faceOvalContour;
    }

    public void setFaceOvalContour(List<Point2> faceOvalContour) {
        this.faceOvalContour = faceOvalContour;
    }

    public List<Point2> getUpperLipBottomContour() {
        return upperLipBottomContour;
    }

    public void setUpperLipBottomContour(List<Point2> upperLipBottomContour) {
        this.upperLipBottomContour = upperLipBottomContour;
    }

    public List<Point2> getLeftEyeContour() {
        return leftEyeContour;
    }

    public void setLeftEyeContour(List<Point2> leftEyeContour) {
        this.leftEyeContour = leftEyeContour;
    }

    public List<Point2> getLeftCheekContour() {
        return leftCheekContour;
    }

    public void setLeftCheekContour(List<Point2> leftCheekContour) {
        this.leftCheekContour = leftCheekContour;
    }

    public List<Point2> getLeftEyebrowBotContour() {
        return leftEyebrowBotContour;
    }

    public void setLeftEyebrowBotContour(List<Point2> leftEyebrowBotContour) {
        this.leftEyebrowBotContour = leftEyebrowBotContour;
    }

    public List<Point2> getRightEyeContour() {
        return rightEyeContour;
    }

    public void setRightEyeContour(List<Point2> rightEyeContour) {
        this.rightEyeContour = rightEyeContour;
    }

    public List<Point2> getLeftEyebrowTopContour() {
        return leftEyebrowTopContour;
    }

    public void setLeftEyebrowTopContour(List<Point2> leftEyebrowTopContour) {
        this.leftEyebrowTopContour = leftEyebrowTopContour;
    }

    public List<Point2> getLowerLipBotContour() {
        return lowerLipBotContour;
    }

    public void setLowerLipBotContour(List<Point2> lowerLipBotContour) {
        this.lowerLipBotContour = lowerLipBotContour;
    }

    public List<Point2> getLowerLipTopContour() {
        return lowerLipTopContour;
    }

    public void setLowerLipTopContour(List<Point2> lowerLipTopContour) {
        this.lowerLipTopContour = lowerLipTopContour;
    }

    public List<Point2> getNoseBotContour() {
        return noseBotContour;
    }

    public void setNoseBotContour(List<Point2> noseBotContour) {
        this.noseBotContour = noseBotContour;
    }

    public List<Point2> getNoseBridgeContour() {
        return noseBridgeContour;
    }

    public void setNoseBridgeContour(List<Point2> noseBridgeContour) {
        this.noseBridgeContour = noseBridgeContour;
    }

    public List<Point2> getUpperLipTopContour() {
        return upperLipTopContour;
    }

    public void setUpperLipTopContour(List<Point2> upperLipTopContour) {
        this.upperLipTopContour = upperLipTopContour;
    }

    public List<Point2> getRightCeekContour() {
        return rightCeekContour;
    }

    public void setRightCeekContour(List<Point2> rightCeekContour) {
        this.rightCeekContour = rightCeekContour;
    }

    public List<Point2> getRightEyebrowBotContour() {
        return rightEyebrowBotContour;
    }

    public void setRightEyebrowBotContour(List<Point2> rightEyebrowBotContour) {
        this.rightEyebrowBotContour = rightEyebrowBotContour;
    }

    public List<Point2> getRightEyebrowTopContour() {
        return rightEyebrowTopContour;
    }

    public void setRightEyebrowTopContour(List<Point2> rightEyebrowTopContour) {
        this.rightEyebrowTopContour = rightEyebrowTopContour;
    }

    public float getRotY() {
        return rotY;
    }

    public void setRotY(float rotY) {
        this.rotY = rotY;
    }

    public float getRotZ() {
        return rotZ;
    }

    public void setRotZ(float rotZ) {
        this.rotZ = rotZ;
    }

    public long getReadingMilisecond() {
        return readingMilisecond;
    }

    public void setReadingMilisecond(long readingMilisecond) {
        this.readingMilisecond = readingMilisecond;
    }
}
