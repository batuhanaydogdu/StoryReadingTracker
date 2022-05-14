package com.impostors.app.ws.storyreadingtrackerws.io.repository.mysql;

import com.impostors.app.ws.storyreadingtrackerws.io.entity.AuthorityEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends CrudRepository<AuthorityEntity, Long> {

    AuthorityEntity findByName(String name);
}
