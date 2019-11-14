package com.example.DynamoDBExample.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class ObjectResponse {
    private String nome;
    private String sobrenome;
    private BigDecimal salarioMensal;
    private String cidade;
    private String uf;
    private String pais;
    private String status;
}
