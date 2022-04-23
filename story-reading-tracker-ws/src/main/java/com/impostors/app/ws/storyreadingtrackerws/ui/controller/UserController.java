package com.impostors.app.ws.storyreadingtrackerws.ui.controller;

import com.impostors.app.ws.storyreadingtrackerws.exceptions.UserServiceException;
import com.impostors.app.ws.storyreadingtrackerws.service.UserService;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.Roles;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.UserDto;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.request.UserDetailsRequestModel;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.response.ErrorMessages;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.response.UserSimpleRest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashSet;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    UserService userService;


    @PostMapping
    public UserSimpleRest createUser(@RequestBody UserDetailsRequestModel userDetails) throws Exception
    {
        UserSimpleRest returnValue=new UserSimpleRest();

        if(userDetails.getFirstName().isEmpty()) throw new UserServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());


        //UserDto userDto=new UserDto();
        //BeanUtils.copyProperties(userDetails, userDto);

        ModelMapper modelMapper=new ModelMapper();
        UserDto userDto=modelMapper.map(userDetails,UserDto.class);
        userDto.setRoles(new HashSet<>(Arrays.asList(Roles.ROLE_USER.name())));
        //TODO here I set student role to everyone but the email which include @isikun.edu.tr is academician
        //who has @isik.edu.tr is student this have to be managed with the frontend team


        UserDto createdUser=userService.createUser(userDto);
        returnValue=modelMapper.map(createdUser, UserSimpleRest.class);


        //BeanUtils.copyProperties(createdUser, returnValue);

        return returnValue;

    }


}
