package com.impostors.app.ws.storyreadingtrackerws.io.repository.mysql;

import com.impostors.app.ws.storyreadingtrackerws.io.entity.AvatarEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvatarRepository extends CrudRepository<AvatarEntity, Long> {

    @Query(value="select r.* from ((avatars r inner join users_avatars ur on r.id=ur.avatars_id) inner join users u on ur.users_id=u.id  ) where u.id = :user_id",nativeQuery = true)
    List<AvatarEntity> findAllAvatarsByUserId(@Param("user_id")long user_id);


    AvatarEntity findByAvatarName(String avatarName);

    List<AvatarEntity> findAll();

}
