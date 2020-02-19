package com.southsystem.banco.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({ @JsonSubTypes.Type(value = LegalPerson.class, name = "PJ"),
        @JsonSubTypes.Type(value = PhysicalPerson.class, name = "PF") })
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Nome não pode ser vazio")
    @Size(max = 50, message = "Nome não pode conter mais de 50 caracteres")
    @Column(length = 50)
    private String name;
    private int score;
    @OneToOne
    private Account account;

    @JsonProperty(value = "type")
    public abstract String getType();
    public abstract int generatePersonScore();
}