package com.example.greatlearning.service;

import com.example.greatlearning.exceptions.CouponNotFoundException;

public interface CouponService {

   public Integer getDiscountValue(String code) throws CouponNotFoundException;

}
