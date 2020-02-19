package com.southsystem.banco.persistence.model;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonTypeName;

import org.hibernate.validator.constraints.br.CPF;

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
@JsonTypeName("PF")
public class PhysicalPerson extends Person{

    @NotEmpty(message = "CPF não pode ser vazio")
    @Size(min = 11, max = 11, message = "Tamanho do CPF deve ser igual à 11")
    @CPF
    private String cpf;

    @Override
    public int generatePersonScore() {
        /*
        * Adicionar regras diferentes se necessário
        */
        Random r = new Random();
        return r.nextInt(10);
    }

    @Override
    public String getType() {
        return "PF";
    }
}