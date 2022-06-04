package com.impostors.app.ws.storyreadingtrackerws.service;

import com.impostors.app.ws.storyreadingtrackerws.shared.dto.AvatarDto;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.UserDto;

import java.util.List;

public interface AvatarService {

    List<AvatarDto> getAvatarsOfCurrentUser();
    AvatarDto createAvatar(AvatarDto avatar);
    AvatarDto buyAvatar(AvatarDto avatar);

    List<AvatarDto> getAllAvatars();
    List<AvatarDto> getUsersAvatars();

}
