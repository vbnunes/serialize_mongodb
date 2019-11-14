package com.example.DynamoDBExample.services;

import com.example.DynamoDBExample.data.SerializableMongoObject;
import com.example.DynamoDBExample.repositorys.ObjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DynamoDBService {
    private final ObjectRepository objectRepository;

    public void save (SerializableMongoObject serializableMongoObject){
        objectRepository.save(serializableMongoObject);
    }

    public Optional<SerializableMongoObject> findById(String id) {
        return objectRepository.findById(id);
    }

    public void delete(String id) {
        objectRepository.deleteById(id);
    }
}
