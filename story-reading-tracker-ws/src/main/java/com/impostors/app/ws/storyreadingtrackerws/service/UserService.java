package com.impostors.app.ws.storyreadingtrackerws.service;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{
    UserDto getUser(String email);
    UserDto createUser(UserDto user);

}
