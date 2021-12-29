package com.example.greatlearning.controller;

import com.example.greatlearning.exceptions.CouponNotFoundException;
import com.example.greatlearning.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/festive-sale")
public class CouponCodeController {

    @Autowired
    CouponService couponService;


    @GetMapping("/getDiscount")
    public Integer getDiscountValue(String code) throws CouponNotFoundException{
           return couponService.getDiscountValue(code);
    }

    @ExceptionHandler(value=CouponNotFoundException.class)
    public ResponseEntity handleCouponNotFoundException(CouponNotFoundException couponNotFoundException){
        return new ResponseEntity("Coupon doesn't exist", HttpStatus.CONFLICT);
    }

}
