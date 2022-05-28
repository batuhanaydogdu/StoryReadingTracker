package com.impostors.app.ws.storyreadingtrackerws.io.repository.mysql;

import com.impostors.app.ws.storyreadingtrackerws.io.entity.RoleEntity;
import com.impostors.app.ws.storyreadingtrackerws.io.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Long> {
    RoleEntity findByName(String name);



    @Query(value="select r.* from ((roles r inner join users_roles ur on r.id=ur.roles_id) inner join users u on ur.users_id=u.id  ) where u.id = :user_id",nativeQuery = true)
    List<RoleEntity> findAllRolesByUserId(@Param("user_id")long user_id);


}
