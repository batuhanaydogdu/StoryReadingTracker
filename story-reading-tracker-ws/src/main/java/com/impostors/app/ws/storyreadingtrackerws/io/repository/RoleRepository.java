package com.impostors.app.ws.storyreadingtrackerws.io.repository;

import com.impostors.app.ws.storyreadingtrackerws.io.entity.RoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Long> {
    RoleEntity findByName(String name);
}
