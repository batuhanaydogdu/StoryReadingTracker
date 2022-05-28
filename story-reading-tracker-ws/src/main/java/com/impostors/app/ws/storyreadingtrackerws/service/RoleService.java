package com.impostors.app.ws.storyreadingtrackerws.service;

import com.impostors.app.ws.storyreadingtrackerws.shared.dto.RoleDto;

import java.util.List;

public interface RoleService {
    List<RoleDto> getRolesOfCurrentUser();
}
