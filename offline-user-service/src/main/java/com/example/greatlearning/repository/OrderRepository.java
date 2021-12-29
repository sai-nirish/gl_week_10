package com.example.greatlearning.repository;

import com.example.greatlearning.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

    @Override
    Optional<Orders> findById(Long integer);
}
