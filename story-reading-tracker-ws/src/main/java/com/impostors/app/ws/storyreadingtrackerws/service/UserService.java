package com.impostors.app.ws.storyreadingtrackerws.service;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService{
    UserDto getUser(String email);
    UserDto createUser(UserDto user);
    UserDto getUserByEmail(String email);
    UserDto getCurrentUser();
    UserDto updateUser(UserDto simpleUserDto);
    List<UserDto> getAllNormalUserListByPoints();

}
