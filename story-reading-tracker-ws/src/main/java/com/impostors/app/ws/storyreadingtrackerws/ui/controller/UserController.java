package com.impostors.app.ws.storyreadingtrackerws.ui.controller;

import com.impostors.app.ws.storyreadingtrackerws.exceptions.StoryServiceException;
import com.impostors.app.ws.storyreadingtrackerws.exceptions.UserServiceException;
import com.impostors.app.ws.storyreadingtrackerws.service.UserService;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.Roles;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.UserDto;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.request.UserDetailsRequestModel;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.request.UserUpdateRequestModel;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.response.ErrorMessages;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.response.UserSimpleRest;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path="/{email}")
    public UserSimpleRest getUser(@PathVariable String email)
    {
        UserSimpleRest returnValue=new UserSimpleRest();

        UserDto userDto= userService.getUserByEmail(email);

        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);

        returnValue=modelMapper.map(userDto, UserSimpleRest.class);

        return returnValue;
    }

    @GetMapping(path="/currentUser")
    public UserSimpleRest getCurrentUser(){
        UserSimpleRest returnValue=new UserSimpleRest();

        UserDto userDto= userService.getCurrentUser();

        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);

        returnValue=modelMapper.map(userDto, UserSimpleRest.class);

        return returnValue;
    }
    @PutMapping(path = "/updateUser")
    public UserSimpleRest updateUser(@RequestBody UserUpdateRequestModel userUpdateRequestModel){
        UserSimpleRest returnValue;
        if(userUpdateRequestModel.getFirstName().isEmpty()||userUpdateRequestModel.getLastName().isEmpty()||userUpdateRequestModel.getGender().isEmpty()){
            throw new StoryServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
        }
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT); //it has to match with perfectly matching names
        UserDto userDto =modelMapper.map(userUpdateRequestModel,UserDto.class);
        UserDto updatedUser = userService.updateUser(userDto);
        returnValue=modelMapper.map(updatedUser,UserSimpleRest.class);
        return returnValue;


    }




}
