package com.impostors.app.ws.storyreadingtrackerws.io.repository.mysql;

import com.impostors.app.ws.storyreadingtrackerws.io.entity.StoryUserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoryUserRepository extends CrudRepository<StoryUserEntity, Long> {


    @Query(value="select su.* from ((users u inner join stories_users su on u.id=su.users_id) "
            +"inner join stories s on s.id=su.stories_id)"
            + " where u.user_id=:userId",nativeQuery = true)
    List<StoryUserEntity> getReadedStoriesOfUser(@Param("userId") String userId);

}
