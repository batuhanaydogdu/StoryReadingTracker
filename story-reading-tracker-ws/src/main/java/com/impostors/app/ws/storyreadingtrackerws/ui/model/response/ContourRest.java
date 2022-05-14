package com.impostors.app.ws.storyreadingtrackerws.ui.model.response;

import java.awt.geom.Point2D;
import java.util.List;

public class ContourRest {
    private List<Point2D> faceOvalContour;
    private List<Point2D> upperLipBottomContour ;
    private List<Point2D> leftEyeContour ;
    private List<Point2D> leftCheekContour;
    private List<Point2D> leftEyebrowBotContour;
    private List<Point2D> rightEyeContour;
    private List<Point2D> leftEyebrowTopContour;
    private List<Point2D> lowerLipBotContour;
    private List<Point2D> lowerLipTopContour;
    private List<Point2D> noseBotContour ;
    private List<Point2D> noseBridgeContour ;
    private List<Point2D> upperLipTopContour ;
    private List<Point2D> rightCeekContour ;
    private List<Point2D> rightEyebrowBotContour ;
    private List<Point2D> rightEyebrowTopContour ;
    private float rotY ;
    private float rotZ;
    private long readingMilisecond;


    public List<Point2D> getFaceOvalContour() {
        return faceOvalContour;
    }

    public void setFaceOvalContour(List<Point2D> faceOvalContour) {
        this.faceOvalContour = faceOvalContour;
    }

    public List<Point2D> getUpperLipBottomContour() {
        return upperLipBottomContour;
    }

    public void setUpperLipBottomContour(List<Point2D> upperLipBottomContour) {
        this.upperLipBottomContour = upperLipBottomContour;
    }

    public List<Point2D> getLeftEyeContour() {
        return leftEyeContour;
    }

    public void setLeftEyeContour(List<Point2D> leftEyeContour) {
        this.leftEyeContour = leftEyeContour;
    }

    public List<Point2D> getLeftCheekContour() {
        return leftCheekContour;
    }

    public void setLeftCheekContour(List<Point2D> leftCheekContour) {
        this.leftCheekContour = leftCheekContour;
    }

    public List<Point2D> getLeftEyebrowBotContour() {
        return leftEyebrowBotContour;
    }

    public void setLeftEyebrowBotContour(List<Point2D> leftEyebrowBotContour) {
        this.leftEyebrowBotContour = leftEyebrowBotContour;
    }

    public List<Point2D> getRightEyeContour() {
        return rightEyeContour;
    }

    public void setRightEyeContour(List<Point2D> rightEyeContour) {
        this.rightEyeContour = rightEyeContour;
    }

    public List<Point2D> getLeftEyebrowTopContour() {
        return leftEyebrowTopContour;
    }

    public void setLeftEyebrowTopContour(List<Point2D> leftEyebrowTopContour) {
        this.leftEyebrowTopContour = leftEyebrowTopContour;
    }

    public List<Point2D> getLowerLipBotContour() {
        return lowerLipBotContour;
    }

    public void setLowerLipBotContour(List<Point2D> lowerLipBotContour) {
        this.lowerLipBotContour = lowerLipBotContour;
    }

    public List<Point2D> getLowerLipTopContour() {
        return lowerLipTopContour;
    }

    public void setLowerLipTopContour(List<Point2D> lowerLipTopContour) {
        this.lowerLipTopContour = lowerLipTopContour;
    }

    public List<Point2D> getNoseBotContour() {
        return noseBotContour;
    }

    public void setNoseBotContour(List<Point2D> noseBotContour) {
        this.noseBotContour = noseBotContour;
    }

    public List<Point2D> getNoseBridgeContour() {
        return noseBridgeContour;
    }

    public void setNoseBridgeContour(List<Point2D> noseBridgeContour) {
        this.noseBridgeContour = noseBridgeContour;
    }

    public List<Point2D> getUpperLipTopContour() {
        return upperLipTopContour;
    }

    public void setUpperLipTopContour(List<Point2D> upperLipTopContour) {
        this.upperLipTopContour = upperLipTopContour;
    }

    public List<Point2D> getRightCeekContour() {
        return rightCeekContour;
    }

    public void setRightCeekContour(List<Point2D> rightCeekContour) {
        this.rightCeekContour = rightCeekContour;
    }

    public List<Point2D> getRightEyebrowBotContour() {
        return rightEyebrowBotContour;
    }

    public void setRightEyebrowBotContour(List<Point2D> rightEyebrowBotContour) {
        this.rightEyebrowBotContour = rightEyebrowBotContour;
    }

    public List<Point2D> getRightEyebrowTopContour() {
        return rightEyebrowTopContour;
    }

    public void setRightEyebrowTopContour(List<Point2D> rightEyebrowTopContour) {
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
