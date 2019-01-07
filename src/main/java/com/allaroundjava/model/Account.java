package com.allaroundjava.model;

import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Immutable
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountNumber;
    private String accountOwnerName;

    private Account() {}

    private Account(String accountNumber, String accountOwnerName) {
        this.accountNumber = accountNumber;
        this.accountOwnerName = accountOwnerName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountOwnerName() {
        return accountOwnerName;
    }
}
