package com.impostors.app.ws.storyreadingtrackerws.ui.controller;


import com.impostors.app.ws.storyreadingtrackerws.exceptions.UserServiceException;
import com.impostors.app.ws.storyreadingtrackerws.service.AvatarService;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.AvatarDto;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.StoryDto;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.request.AvatarDetailsRequestModel;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.response.AvatarRest;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.response.ErrorMessages;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.response.StoryRest;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping(path="/allAvatars")
    public List<AvatarRest> getAllAvatars(){
        ArrayList<AvatarRest> returnValue=new ArrayList<>();

        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT); //Intelligently matches source and destination properties

        List<AvatarDto> takenAvatars=new ArrayList<>();

        takenAvatars=avatarService.getAllAvatars();

        for(AvatarDto avatarDto :takenAvatars){
            returnValue.add(modelMapper.map(avatarDto,AvatarRest.class));
        }

        return returnValue;
    }

    @GetMapping(path="/userAvatars")
    public List<AvatarRest> getUserAvatars(){
        ArrayList<AvatarRest> returnValue=new ArrayList<>();

        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT); //Intelligently matches source and destination properties

        List<AvatarDto> takenAvatars=new ArrayList<>();

        takenAvatars=avatarService.getUsersAvatars();

        for(AvatarDto avatarDto :takenAvatars){
            returnValue.add(modelMapper.map(avatarDto,AvatarRest.class));
        }

        return returnValue;
    }

    @PutMapping(path="/selectAvatar")
    public AvatarRest selectAvatar(@RequestBody AvatarDetailsRequestModel avatarDetailsRequestModel){
        AvatarRest returnValue=new AvatarRest();
        ModelMapper modelMapper=new ModelMapper();
        AvatarDto avatarDto=modelMapper.map(avatarDetailsRequestModel,AvatarDto.class);


        AvatarDto createdAvatar=avatarService.selectAvatar(avatarDto);
        returnValue=modelMapper.map(createdAvatar, AvatarRest.class);
        return returnValue;


    }



}
