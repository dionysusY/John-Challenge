package com.boot.challenge.dao;

import com.boot.challenge.entity.DatabaseSequence;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DatabaseSequenceRepository extends MongoRepository<DatabaseSequence, String> {

    public default long generateSequence(String seqName) {
        Optional<DatabaseSequence> findResult = this.findById(seqName);
        DatabaseSequence counter = null;
        if (findResult.isPresent()){
            counter = findResult.get();
        }else {
            counter = new DatabaseSequence(seqName);
        }

        long nextId = counter.getSeq();
        counter.setSeq(nextId + 1);
        this.save(counter);
        return nextId;
    }

}
