package com.example.greatlearning.controller;

import com.example.greatlearning.exception.OrderNotFoundException;
import com.example.greatlearning.model.Items;
import com.example.greatlearning.model.Order;
import com.example.greatlearning.model.PaymentMode;
import com.example.greatlearning.service.OfflineUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offline-users/")
@Slf4j
public class OfflineUserController {

    @Autowired
    OfflineUserService offlineUserService;

    @GetMapping(value="view-menu")
    public List<Items> viewMenu(){
       return offlineUserService.viewMenu();
    }

    /**
     * books the seat and returns the id of booking
      * @return id of the booking
     */
    @GetMapping(value="book-seat")
    public Long bookSeat()  {
        return offlineUserService.bookSeat();
    }


    /** Place orders with multiple items and quantities
     * returns true once the order is placed */
    @PostMapping(value="order")
    public boolean Order(@RequestParam Long id, @RequestBody List<Order> orders) throws  OrderNotFoundException{
        return offlineUserService.order(id, orders);
    }

    /** Get the bill and pay with a payment mode
     * returns the amount of bill */
    @PostMapping(value="getBill")
    public Integer getBill(@RequestParam Long id, @RequestParam PaymentMode mode) throws OrderNotFoundException{
        return offlineUserService.getBill(id, mode);
    }

    /** Give feedback
     * returns true if feedback is submitted */
    @PostMapping(value="feedback")
    public boolean giveFeedback(@RequestParam Long id, @RequestParam String feedback, @RequestParam Integer rating) throws OrderNotFoundException{
        return offlineUserService.giveFeedback(id, feedback, rating);
    }

    @ExceptionHandler(value= OrderNotFoundException.class)
    public ResponseEntity handleCouponNotFoundException(OrderNotFoundException orderNotFoundException){
        return new ResponseEntity("order doesn't exist", HttpStatus.CONFLICT);
    }
}
