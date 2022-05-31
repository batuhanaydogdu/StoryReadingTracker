package com.impostors.app.ws.storyreadingtrackerws.service;

import com.impostors.app.ws.storyreadingtrackerws.shared.dto.PasswordChangeDto;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.request.PasswordChangeRequestModel;

public interface PasswordChangeService {
    PasswordChangeDto createVerificationCode(String email);
    void changePassword(PasswordChangeRequestModel passwordChangeRequestModel);
}
