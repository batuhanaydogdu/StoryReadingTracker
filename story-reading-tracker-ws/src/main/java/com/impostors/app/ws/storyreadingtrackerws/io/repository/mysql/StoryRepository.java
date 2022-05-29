package com.impostors.app.ws.storyreadingtrackerws.io.repository.mysql;

import com.impostors.app.ws.storyreadingtrackerws.io.entity.StoryEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoryRepository extends CrudRepository<StoryEntity, Long> {

    StoryEntity findByTitle(String title);
    StoryEntity findByStoryId(String storyId);

    @Query(value="select * from stories s where s.row_status=true order by rand() limit 1",nativeQuery = true)
    StoryEntity getRandomStory();

    @Query(value="select * from stories s where s.row_status=true ",nativeQuery = true)
    List<StoryEntity> getAllStories();


}
