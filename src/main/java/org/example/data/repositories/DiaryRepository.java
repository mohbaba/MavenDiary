package org.example.data.repositories;

import org.example.data.models.Diary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  DiaryRepository extends MongoRepository<Diary, String> {
}
