package com.impostors.app.ws.storyreadingtrackerws.service;

import com.impostors.app.ws.storyreadingtrackerws.shared.dto.ContourDto;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.FaceExperienceDto;

import java.util.List;

public interface FaceExperienceService {

    FaceExperienceDto createFaceExperience(String storyId);
    void addContour(ContourDto contourDto, String faceExperienceId);
    void addAllContours(List<ContourDto> contourDtoList, String faceExperienceId);

}
