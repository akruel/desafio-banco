package com.southsystem.banco.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({ @JsonSubTypes.Type(value = CurrentAccount.class, name = "C"),
        @JsonSubTypes.Type(value = BusinessAccount.class, name = "E") })
public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String account;
    private String agency;
    private Double overdraftLimit;
    private Double creditCardLimit;
    @OneToOne

    public void generateAccount(Long id) {
        this.account = String.format("%06d", id);
    }

    public void generateOverdraftLimit(int score) {
        Double overdraftLimit = null;
        if (score == 0 || score == 1) {
            overdraftLimit = null;
        } else if (score >= 2 && score <= 5) {
            overdraftLimit = 1000.00;
        } else if (score >= 6 && score <= 8) {
            overdraftLimit = 2000.00;
        } else if (score == 9) {
            overdraftLimit = 5000.00;
        }
        this.setOverdraftLimit(overdraftLimit);
    }

    public void generateCreditCardLimit(int score) {
        Double creditCardLimit = null;
        if (score == 0 || score == 1) {
            creditCardLimit = null;
        } else if (score >= 2 && score <= 5) {
            creditCardLimit = 200.00;
        } else if (score >= 6 && score <= 8) {
            creditCardLimit = 2000.00;
        } else if (score == 9) {
            creditCardLimit = 15000.00;
        }
        this.setCreditCardLimit(creditCardLimit);
    }
}