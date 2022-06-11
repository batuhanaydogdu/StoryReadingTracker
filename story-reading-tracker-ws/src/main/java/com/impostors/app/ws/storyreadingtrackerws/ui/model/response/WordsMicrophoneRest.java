package com.impostors.app.ws.storyreadingtrackerws.ui.model.response;

public class WordsMicrophoneRest {
    private String expectedWord ;
    private String readedWord;
    private long readingMilisecond;


    public String getExpectedWord() {
        return expectedWord;
    }

    public void setExpectedWord(String expectedWord) {
        this.expectedWord = expectedWord;
    }

    public String getReadedWord() {
        return readedWord;
    }

    public void setReadedWord(String readedWord) {
        this.readedWord = readedWord;
    }

    public long getReadingMilisecond() {
        return readingMilisecond;
    }

    public void setReadingMilisecond(long readingMilisecond) {
        this.readingMilisecond = readingMilisecond;
    }
}
