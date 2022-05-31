package com.impostors.app.ws.storyreadingtrackerws.ui.controller;


import com.impostors.app.ws.storyreadingtrackerws.exceptions.UserServiceException;
import com.impostors.app.ws.storyreadingtrackerws.service.PasswordChangeService;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.PasswordChangeDto;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.Roles;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.UserDto;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.request.PasswordChangeRequestModel;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.request.StoryRequestModel;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.request.UserDetailsRequestModel;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.response.ErrorMessages;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.response.PasswordChangeRest;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.response.UserSimpleRest;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashSet;

@RestController
@RequestMapping("passwordChanges")
public class PasswordChangeController {
    @Autowired
    PasswordChangeService passwordChangeService;



    @PostMapping(path = "email/{email}")
    public PasswordChangeRest createVerificationCode(@PathVariable String email) throws Exception
    {
        PasswordChangeRest returnValue=new PasswordChangeRest();

        if(email.isEmpty()) throw new UserServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());





        PasswordChangeDto passwordChangeDto=passwordChangeService.createVerificationCode(email);

        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT); //it has to match with perfectly matching names


        returnValue=modelMapper.map(passwordChangeDto,PasswordChangeRest.class);



        //BeanUtils.copyProperties(createdUser, returnValue);

        return returnValue;

    }
    @PutMapping()
    public void  changePassword(@RequestBody PasswordChangeRequestModel passwordChangeRequestModel) throws Exception
    {

        if(passwordChangeRequestModel.getEmail().isEmpty()) throw new UserServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());





        passwordChangeService.changePassword(passwordChangeRequestModel);



        //BeanUtils.copyProperties(createdUser, returnValue);


    }




}
