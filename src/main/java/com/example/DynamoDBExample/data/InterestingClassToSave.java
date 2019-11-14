package com.example.DynamoDBExample.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
public class InterestingClassToSave implements Serializable {
    private String nome;
    private String sobrenome;
    private BigDecimal salario;
    private String cidade;
    private String uf;
    private String pais;
}
