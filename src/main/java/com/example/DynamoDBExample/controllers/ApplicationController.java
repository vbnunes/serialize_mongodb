package com.example.DynamoDBExample.controllers;

import com.example.DynamoDBExample.data.InterestingClassToSave;
import com.example.DynamoDBExample.data.ObjectRequest;
import com.example.DynamoDBExample.data.ObjectResponse;
import com.example.DynamoDBExample.data.SerializableMongoObject;
import com.example.DynamoDBExample.services.DynamoDBService;
import com.example.DynamoDBExample.utils.Helper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class ApplicationController {

    private final DynamoDBService dynamoDBService;

    @PostMapping("/saveObject")
    public ResponseEntity<ObjectResponse> saveObject(@RequestBody ObjectRequest objectRequest) throws IOException {
        InterestingClassToSave classToSave = InterestingClassToSave.builder()
                .nome(objectRequest.getNome())
                .sobrenome(objectRequest.getSobrenome())
                .salario(objectRequest.getSalarioMensal())
                .cidade("Campinas")
                .uf("SP")
                .pais("Brasil")
                .build();

        final String objectAsString = Helper.toString(classToSave);

        SerializableMongoObject mongoObject = SerializableMongoObject.builder()
                .id("1234567")
                .data(objectAsString)
                .build();

        dynamoDBService.save(mongoObject);

        ObjectResponse test = ObjectResponse.builder()
                .nome(objectRequest.getNome())
                .build();

        return ResponseEntity.ok(test);
    }

    @GetMapping("/getObject/{id}")
    public ResponseEntity<?> getObject(@PathVariable("id") String id) throws ClassNotFoundException, IOException {

        Optional<SerializableMongoObject> object = dynamoDBService.findById(id);

        InterestingClassToSave classToSave = null;

        if (object.isPresent()) {
            classToSave = (InterestingClassToSave) Helper.fromString(object.get().getData());
        } else {
            return ResponseEntity.noContent().build();
        }

        ObjectResponse test = ObjectResponse.builder()
                .nome(classToSave.getNome())
                .sobrenome(classToSave.getSobrenome())
                .salarioMensal(classToSave.getSalario())
                .cidade(classToSave.getCidade())
                .uf(classToSave.getUf())
                .pais(classToSave.getPais())
                .status("200")
                .build();

        dynamoDBService.delete(id);

        return ResponseEntity.ok(test);
    }
}
