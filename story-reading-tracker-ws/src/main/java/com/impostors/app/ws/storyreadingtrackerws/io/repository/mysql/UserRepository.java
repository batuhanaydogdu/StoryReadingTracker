package com.impostors.app.ws.storyreadingtrackerws.io.repository.mysql;

import java.util.List;

import com.impostors.app.ws.storyreadingtrackerws.io.entity.StoryEntity;
import com.impostors.app.ws.storyreadingtrackerws.io.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);
    UserEntity findByUserId(String userId);
    UserEntity findUserByEmailVerificationToken(String token);

    @Query(value="select * from Users u where u.EMAIL_VERIFICATION_STATUS='true'",
            countQuery="select * from Users u where u.EMAIL_VERIFICATION_STATUS='true'"
            ,nativeQuery=true)
    Page<UserEntity> findAllUsersWithConfirmedEmailAddress(Pageable pageableRequest);


    @Query(value="SELECT u.*\n" +
            "FROM (users u inner join users_roles ur on ur.users_id=u.id) inner join roles r on r.id=ur.roles_id\n" +
            "where r.name!='ROLE_ADMIN'\n" +
            "ORDER BY u.points desc ",nativeQuery = true)
    List<UserEntity> getAllUsersNotAdmins();



    @Query(value="select * from Users u where u.first_name=?1 ",nativeQuery = true)
    List<UserEntity> findUserByFirstName(String firstName);

    @Query(value="select * from Users u where u.first_name=:lastName ",nativeQuery = true)
    List<UserEntity> findUserByLastName(@Param("lastName")String lastName);

    @Query(value="select * from Users u where u.first_name LIKE %:keyword%",nativeQuery = true)
    List<UserEntity> findUsersByKeyword(@Param("keyword")String keyword);

    @Query(value="select u.first_name,u.last_name from Users u where u.first_name LIKE %:keyword%",nativeQuery = true)
    List<Object[]> findUserFirstNameAndLastNameByKeyword(@Param("keyword")String keyword);

    @Transactional
    @Modifying
    @Query(value="update users u set u.EMAIL_VERIFICATION_STATUS=:emailVerificationStatus where u.user_id=:userId",nativeQuery = true)
    void updateUserEmailVerificationStatus(@Param("emailVerificationStatus")boolean emailVerificationStatus,
                                           @Param("userId")String userId);
}
