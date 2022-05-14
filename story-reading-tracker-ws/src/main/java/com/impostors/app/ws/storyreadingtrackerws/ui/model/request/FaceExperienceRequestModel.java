package com.impostors.app.ws.storyreadingtrackerws.ui.model.request;

import com.impostors.app.ws.storyreadingtrackerws.io.document.Contour;

import java.util.Date;
import java.util.List;

public class FaceExperienceRequestModel {



    private List<Contour> Points;


    public List<Contour> getPoints() {
        return Points;
    }

    public void setPoints(List<Contour> points) {
        Points = points;
    }
}
