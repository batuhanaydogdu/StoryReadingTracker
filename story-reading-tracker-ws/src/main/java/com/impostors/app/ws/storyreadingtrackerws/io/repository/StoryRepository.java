package com.impostors.app.ws.storyreadingtrackerws.io.repository;

import com.impostors.app.ws.storyreadingtrackerws.io.entity.StoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryRepository extends CrudRepository<StoryEntity, Long> {

    StoryEntity findByTitle(String title);
    StoryEntity findByStoryId(String storyId);


}
