package com.example.DynamoDBExample.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@Document(collection = "DynamoDBTeste")
public class SerializableMongoObject {
    @Id
    private String id;
    private String data;
}
