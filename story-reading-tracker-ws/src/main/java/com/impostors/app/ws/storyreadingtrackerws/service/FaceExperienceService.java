package com.impostors.app.ws.storyreadingtrackerws.service;

import com.impostors.app.ws.storyreadingtrackerws.shared.dto.ContourDto;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.FaceExperienceDto;

public interface FaceExperienceService {

    FaceExperienceDto createFaceExperience(String storyId);
    void addContour(ContourDto contourDto, String faceExperienceId);

}
