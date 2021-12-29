package com.example.greatlearning.serviceImpl;

import com.example.greatlearning.entity.Coupon;
import com.example.greatlearning.exceptions.CouponNotFoundException;
import com.example.greatlearning.repository.CouponRepository;
import com.example.greatlearning.service.CouponService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class CouponServiceImpl implements CouponService {

    @Autowired
    CouponRepository couponRepository;

    /** Get discount for a coupon if it exists, else throw an error */
    @Override
    public Integer getDiscountValue(String code) throws CouponNotFoundException {
        code = code.toUpperCase();
        Optional<Coupon> coupon = couponRepository.findByCouponCode(code);
        if(coupon.isPresent()){
            return coupon.get().getDiscountPercent();
        }
        throw new CouponNotFoundException();
    }
}
