package com.allaroundjava.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.Optional;
import java.util.function.Consumer;

abstract class BaseDao<T> implements Dao<T> {
    private static final Logger log = LogManager.getLogger(BaseDao.class);
    private final Class<T> aClass;
    protected final EntityManagerFactory emf;

    BaseDao(Class<T> aClass, EntityManagerFactory emf) {
        this.aClass = aClass;
        this.emf = emf;
    }

    protected void executeInTransaction(Consumer<EntityManager> consumer) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        consumer.accept(entityManager);

        transaction.commit();
        entityManager.close();
    }

    @Override
    public Optional<T> getById(Long id) {
        log.debug("Fetching {} with id {} from database", getClass(), id);
        EntityManager entityManager = emf.createEntityManager();
        return Optional.ofNullable(entityManager.find(aClass, id));
    }

    @Override
    public void persist(T item) {
        log.debug("Persisting {}",
                item.getClass());
        executeInTransaction(entityManager -> entityManager.persist(item));
    }

    @Override
    public void merge(T item) {
        executeInTransaction(entityManager -> entityManager.merge(item));
    }
}
