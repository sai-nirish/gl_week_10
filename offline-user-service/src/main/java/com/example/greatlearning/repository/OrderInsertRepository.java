package com.example.greatlearning.repository;

import com.example.greatlearning.entity.Orders;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class OrderInsertRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Long insertWithEntityManager(Orders order) {
        this.entityManager.persist(order);
        this.entityManager.flush();
        return order.getId();
    }
}
