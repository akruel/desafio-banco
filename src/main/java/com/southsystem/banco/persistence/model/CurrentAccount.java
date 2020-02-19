package com.southsystem.banco.persistence.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name = "ACCOUNT_ID")
public class CurrentAccount extends Account {
    // Caso no futuro existam regras diferentes para Conta C ou E
    @Override
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

    // Caso no futuro existam regras diferentes para Conta C ou E
    @Override
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