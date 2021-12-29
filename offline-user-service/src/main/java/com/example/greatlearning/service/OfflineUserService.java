package com.example.greatlearning.service;

import com.example.greatlearning.exception.OrderNotFoundException;
import com.example.greatlearning.model.Items;
import com.example.greatlearning.model.Order;
import com.example.greatlearning.model.PaymentMode;

import java.util.List;

public interface OfflineUserService {

    List<Items> viewMenu();

    Long bookSeat();

    boolean order(Long id, List<Order> orders);

    Integer getBill(Long id, PaymentMode mode) throws OrderNotFoundException;

    boolean giveFeedback(Long id, String feedback, Integer rating);
}
