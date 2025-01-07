package com.table.crud.repository;

import com.table.crud.model.MyModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyRepository extends MongoRepository<MyModel, String> {
}
