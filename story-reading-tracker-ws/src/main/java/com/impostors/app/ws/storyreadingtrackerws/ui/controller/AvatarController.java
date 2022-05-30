package com.impostors.app.ws.storyreadingtrackerws.ui.controller;


import com.impostors.app.ws.storyreadingtrackerws.exceptions.UserServiceException;
import com.impostors.app.ws.storyreadingtrackerws.service.AvatarService;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.AvatarDto;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.request.AvatarDetailsRequestModel;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.response.AvatarRest;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.response.ErrorMessages;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("avatars")
public class AvatarController {


    @Autowired
    AvatarService avatarService;

    @PostMapping
    public AvatarRest createAvatar(@RequestBody AvatarDetailsRequestModel avatarDetailsRequestModel) throws Exception
    {
        AvatarRest returnValue=new AvatarRest();
        if(avatarDetailsRequestModel.getAvatarURL().isEmpty()||avatarDetailsRequestModel.getAvatarName().isEmpty()) throw new UserServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());



        ModelMapper modelMapper=new ModelMapper();
        AvatarDto avatarDto=modelMapper.map(avatarDetailsRequestModel,AvatarDto.class);


        AvatarDto createdAvatar=avatarService.createAvatar(avatarDto);
        returnValue=modelMapper.map(createdAvatar, AvatarRest.class);

        return returnValue;

    }

    @PostMapping(path = "/buy")
    public AvatarRest buyAvatar(@RequestBody AvatarDetailsRequestModel avatarDetailsRequestModel){
        AvatarRest returnValue=new AvatarRest();
        if(avatarDetailsRequestModel.getAvatarURL().isEmpty()||avatarDetailsRequestModel.getAvatarName().isEmpty()) throw new UserServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());

        ModelMapper modelMapper=new ModelMapper();
        AvatarDto avatarDto=modelMapper.map(avatarDetailsRequestModel,AvatarDto.class);


        AvatarDto createdAvatar=avatarService.buyAvatar(avatarDto);
        returnValue=modelMapper.map(createdAvatar, AvatarRest.class);
        return returnValue;
    }





}
