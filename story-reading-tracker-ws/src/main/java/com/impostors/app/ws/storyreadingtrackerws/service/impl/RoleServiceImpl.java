package com.impostors.app.ws.storyreadingtrackerws.service.impl;

import com.impostors.app.ws.storyreadingtrackerws.io.entity.RoleEntity;
import com.impostors.app.ws.storyreadingtrackerws.io.entity.UserEntity;
import com.impostors.app.ws.storyreadingtrackerws.io.repository.mysql.RoleRepository;
import com.impostors.app.ws.storyreadingtrackerws.io.repository.mysql.UserRepository;
import com.impostors.app.ws.storyreadingtrackerws.service.RoleService;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.RoleDto;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.response.RoleRest;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;



    @Override
    public List<RoleDto> getRolesOfCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }


        UserEntity userEntity=userRepository.findByEmail(username);

        List<RoleEntity> roleEntities=roleRepository.findAllRolesByUserId(userEntity.getId());


        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT); //it has to match with perfectly matching names


        List<RoleDto> returnValue=new ArrayList<>();

        for(RoleEntity roleEntity:roleEntities){
            RoleDto roleDto=modelMapper.map(roleEntity,RoleDto.class);
            returnValue.add(roleDto);

        }

        return returnValue;


    }
}
