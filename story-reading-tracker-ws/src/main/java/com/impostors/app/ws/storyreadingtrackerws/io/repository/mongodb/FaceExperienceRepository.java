package com.impostors.app.ws.storyreadingtrackerws.io.repository.mongodb;

import com.impostors.app.ws.storyreadingtrackerws.io.document.FaceExperienceDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FaceExperienceRepository extends MongoRepository<FaceExperienceDocument,String> {
}
