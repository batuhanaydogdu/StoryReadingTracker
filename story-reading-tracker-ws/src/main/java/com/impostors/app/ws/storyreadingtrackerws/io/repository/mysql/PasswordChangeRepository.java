package com.impostors.app.ws.storyreadingtrackerws.io.repository.mysql;


import com.impostors.app.ws.storyreadingtrackerws.io.entity.PasswordChangeEntity;
import com.impostors.app.ws.storyreadingtrackerws.io.entity.RoleEntity;
import com.impostors.app.ws.storyreadingtrackerws.io.entity.StoryEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PasswordChangeRepository extends CrudRepository<PasswordChangeEntity, Long> {

    @Query(value="select * from password_changes pc where pc.users_id=:users_id ",nativeQuery = true)
    List<PasswordChangeEntity> getAllVerificationCodes(@Param("users_id") long users_id);


}
