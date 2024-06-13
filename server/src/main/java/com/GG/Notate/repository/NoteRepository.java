package com.GG.Notate.repository;

import com.GG.Notate.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends MongoRepository<Note, String> {
    // You can define custom query methods here if needed
}
