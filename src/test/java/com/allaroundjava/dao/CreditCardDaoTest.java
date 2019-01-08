package com.allaroundjava.dao;

import com.allaroundjava.model.Account;
import com.allaroundjava.model.CreditCard;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Optional;

public class CreditCardDaoTest {
    private EntityManagerFactory emf;
    private Dao<CreditCard> creditCardDao;
    private Dao<Account> accountDao;

    public CreditCardDaoTest() {
        this.emf = Persistence.createEntityManagerFactory("unidirectionalManyToOne");
        creditCardDao = new CreditCardDao(emf);
        accountDao = new AccountDao(emf);
    }

    @Test
    public void whenPersistCreditCard_thenIdAssigned() {
        Account account = Account.newInstance("12345", "James Bone");
        CreditCard creditCard = CreditCard.newInstance("123-456", LocalDate.now(), account);

        accountDao.persist(account);
        creditCardDao.persist(creditCard);
        Assert.assertNotNull(creditCard.getId());
    }

    @Test
    public void whenRetrieveById_thenCorrectObjectReceived() {
        Account account = Account.newInstance("6789", "Henry Towel");
        CreditCard creditCard = CreditCard.newInstance("987-7654", LocalDate.now(), account);
        accountDao.persist(account);
        creditCardDao.persist(creditCard);

        Optional<CreditCard> creditCardOptional = creditCardDao.getById(creditCard.getId());
        Assert.assertTrue(creditCardOptional.isPresent());
        Account fetchedAccount = creditCardOptional.get().getAccount();
        Assert.assertEquals(account.getAccountNumber(), fetchedAccount.getAccountNumber());
    }
}