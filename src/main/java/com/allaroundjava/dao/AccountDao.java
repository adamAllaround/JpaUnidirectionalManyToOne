package com.allaroundjava.dao;

import com.allaroundjava.model.Account;

import javax.persistence.EntityManagerFactory;

public class AccountDao extends BaseDao<Account> {
    AccountDao(EntityManagerFactory emf) {
        super(Account.class, emf);
    }
}
