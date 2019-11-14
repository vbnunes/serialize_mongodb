package com.example.DynamoDBExample.repositorys;

import com.example.DynamoDBExample.data.SerializableMongoObject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectRepository extends MongoRepository<SerializableMongoObject, String> {}
