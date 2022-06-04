package com.impostors.app.ws.storyreadingtrackerws.io.repository.mysql;

import com.impostors.app.ws.storyreadingtrackerws.io.entity.FeedbackEntity;
import com.impostors.app.ws.storyreadingtrackerws.io.entity.StoryEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends CrudRepository<FeedbackEntity, Long> {


    @Query(value="select * from feedbacks f where f.feedback_read=false ",nativeQuery = true)
    List<FeedbackEntity> getAllFeedbacks();

    FeedbackEntity findByFeedbackId(String feedbackId);

}
