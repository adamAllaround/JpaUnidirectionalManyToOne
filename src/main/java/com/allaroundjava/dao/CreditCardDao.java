package com.allaroundjava.dao;

import com.allaroundjava.model.CreditCard;

import javax.persistence.EntityManagerFactory;

public class CreditCardDao extends BaseDao<CreditCard> {
    CreditCardDao(Class<CreditCard> aClass, EntityManagerFactory emf) {
        super(CreditCard.class, emf);
    }
}
