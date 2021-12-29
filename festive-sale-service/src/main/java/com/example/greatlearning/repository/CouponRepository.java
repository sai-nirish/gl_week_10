package com.example.greatlearning.repository;

import com.example.greatlearning.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Integer> {

    @Query("select c from Coupon c where c.code = ?1")
    Optional<Coupon> findByCouponCode(String code);
}
