package com.impostors.app.ws.storyreadingtrackerws.io.repository;

import com.impostors.app.ws.storyreadingtrackerws.io.entity.StoryUserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryUserRepository extends CrudRepository<StoryUserEntity, Long> {
}
