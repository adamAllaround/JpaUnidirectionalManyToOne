package com.allaroundjava.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@org.hibernate.annotations.Immutable
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cardNumber;
    private LocalDate expirationDate;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ACCOUNT_ID", nullable = false)
    private Account account;

    CreditCard() {
    }

    CreditCard(String cardNumber, LocalDate expirationDate, Account account) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public Account getAccount() {
        return account;
    }

    public static CreditCard newInstance(String cardNumber, LocalDate expirationDate, Account account) {
        return new CreditCard(cardNumber, expirationDate, account);
    }
}
