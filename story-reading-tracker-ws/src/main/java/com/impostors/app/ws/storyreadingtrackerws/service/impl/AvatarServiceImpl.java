package com.impostors.app.ws.storyreadingtrackerws.service.impl;

import com.impostors.app.ws.storyreadingtrackerws.exceptions.UserAvatarException;
import com.impostors.app.ws.storyreadingtrackerws.io.entity.AvatarEntity;
import com.impostors.app.ws.storyreadingtrackerws.io.entity.RoleEntity;
import com.impostors.app.ws.storyreadingtrackerws.io.entity.StoryEntity;
import com.impostors.app.ws.storyreadingtrackerws.io.entity.UserEntity;
import com.impostors.app.ws.storyreadingtrackerws.io.repository.mysql.AvatarRepository;
import com.impostors.app.ws.storyreadingtrackerws.io.repository.mysql.RoleRepository;
import com.impostors.app.ws.storyreadingtrackerws.io.repository.mysql.UserRepository;
import com.impostors.app.ws.storyreadingtrackerws.service.AvatarService;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.*;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.response.ErrorMessages;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
@Service
public class AvatarServiceImpl implements AvatarService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AvatarRepository avatarRepository;

    @Autowired
    Utils utils;

    @Override
    public List<AvatarDto> getAvatarsOfCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        UserEntity userEntity=userRepository.findByEmail(username);

        List<AvatarEntity> avatarEntities = avatarRepository.findAllAvatarsByUserId(userEntity.getId());

        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT); //it has to match with perfectly matching names


        List<AvatarDto> returnValue=new ArrayList<>();

        for(AvatarEntity avatarEntity:avatarEntities){
            AvatarDto avatarDto=modelMapper.map(avatarEntity,AvatarDto.class);
            returnValue.add(avatarDto);

        }
        return returnValue;
    }

    @Override
    public AvatarDto createAvatar(AvatarDto avatar) {
        if(avatarRepository.findByAvatarName(avatar.getAvatarName())!=null)
        {
            throw new RuntimeException("Record already exists.");
        }
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }


        UserEntity userEntity=userRepository.findByEmail(username);




        ModelMapper modelMapper=new ModelMapper();
        AvatarEntity avatarEntity=modelMapper.map(avatar, AvatarEntity.class);



        String publicAvatarId = utils.generateAvatarId(8);

        avatarEntity.setAvatarId(publicAvatarId);


        AvatarEntity storedAvatarDetails= avatarRepository.save(avatarEntity);


        AvatarDto returnValue=modelMapper.map(storedAvatarDetails, AvatarDto.class);

        return returnValue;
    }

    @Override
    public AvatarDto buyAvatar(AvatarDto avatar) throws RuntimeException {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        ModelMapper modelMapper=new ModelMapper();

        AvatarEntity avatarEntity = avatarRepository.findByAvatarName(avatar.getAvatarName());
        AvatarDto returnValue= modelMapper.map(avatarEntity,AvatarDto.class);

        UserEntity userEntity=userRepository.findByEmail(username);
        if(userEntity.getPoints()>avatar.getAvatarPrice()){
            userEntity.setPoints(userEntity.getPoints()- avatar.getAvatarPrice());
            userEntity.getAvatars().add(avatarEntity);
            userRepository.save(userEntity);
        }
        else throw new UserAvatarException(ErrorMessages.NO_ENUGH_CREDIT.getErrorMessage());





        return returnValue;
    }

    @Override
    public List<AvatarDto> getAllAvatars() {
        List<AvatarEntity> avatarEntities=new ArrayList<>();
        List<AvatarDto> returnValue=new ArrayList<>();

        ModelMapper modelMapper=new ModelMapper();
        avatarEntities=avatarRepository.findAll();
        for(AvatarEntity avatarEntity: avatarEntities){


            returnValue.add(modelMapper.map(avatarEntity,AvatarDto.class));
        }

        return returnValue;
    }
}
