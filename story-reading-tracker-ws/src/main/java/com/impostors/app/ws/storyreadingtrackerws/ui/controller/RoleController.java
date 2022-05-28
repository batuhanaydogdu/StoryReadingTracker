package com.impostors.app.ws.storyreadingtrackerws.ui.controller;

import com.impostors.app.ws.storyreadingtrackerws.service.RoleService;
import com.impostors.app.ws.storyreadingtrackerws.service.StoryUserService;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.RoleDto;
import com.impostors.app.ws.storyreadingtrackerws.shared.dto.StoryDto;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.response.RoleRest;
import com.impostors.app.ws.storyreadingtrackerws.ui.model.response.StoryRest;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("roles")
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping()
    public List<RoleRest> getRandomStory()
    {
        List<RoleRest> returnValue=new ArrayList<>();




        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT); //it has to match with perfectly matching names

        List<RoleDto> takenRoles=roleService.getRolesOfCurrentUser();

        for(RoleDto roleDto:takenRoles){
            RoleRest rs=modelMapper.map(roleDto,RoleRest.class);
            returnValue.add(rs);

        }



        return returnValue;
    }

}
