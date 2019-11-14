package com.example.DynamoDBExample.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
public class ObjectRequest {
    private String nome;
    private String sobrenome;
    private BigDecimal salarioMensal;
}
