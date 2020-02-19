package com.southsystem.banco.persistence.model;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonTypeName;

import org.hibernate.validator.constraints.br.CNPJ;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name="PERSON_ID")
@JsonTypeName("PJ")
public class LegalPerson extends Person {

    @NotEmpty(message = "CNPJ não pode ser vazio")
    @Size(min = 14, max = 14, message = "Tamanho do CNPJ deve ser igual à 14")
    @CNPJ
    private String cnpj;

    @Override
    public int generatePersonScore() {
        /*
        * Futuramente adicionar regras diferentes se necessário
        */
        Random r = new Random();
        return r.nextInt(10);
    }

    @Override
    public String getType() {
        return "PJ";
    }
}