package com.example.greatlearning.serviceImpl;

import com.example.greatlearning.entity.Orders;
import com.example.greatlearning.exception.OrderNotFoundException;
import com.example.greatlearning.feignclients.UserClient;
import com.example.greatlearning.model.Items;
import com.example.greatlearning.model.Order;
import com.example.greatlearning.model.PaymentMode;
import com.example.greatlearning.repository.OrderInsertRepository;
import com.example.greatlearning.repository.OrderRepository;
import com.example.greatlearning.service.OfflineUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class OfflineUserServiceImpl implements OfflineUserService {

    @Autowired
    UserClient userClient;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderInsertRepository orderInsertRepository;

    @Override
    public List<Items> viewMenu() {
        return userClient.getItems();
    }

    @Override
    public Long bookSeat() {
        Orders order = Orders.builder().bookingDate(new Date()).
                paymentMode(PaymentMode.CASH).paymentStatus(false).build();
        return orderInsertRepository.insertWithEntityManager(order);
    }

    @Override
    public boolean order(Long id, List<Order> orders) throws OrderNotFoundException {
            Optional<Orders> order = orderRepository.findById(id);
            if(order.isPresent()){
                order.get().setItems(orders);
                orderInsertRepository.insertWithEntityManager(order.get());
                return true;
            }
            throw new OrderNotFoundException();
    }

    @Override
    public Integer getBill(Long id, PaymentMode mode) throws OrderNotFoundException {
        Optional<Orders> ordersOptional = orderRepository.findById(id);
        if(ordersOptional.isPresent()){
            Orders order = ordersOptional.get();
            order.setPaymentMode(mode);
            order.setPaymentStatus(true);
            orderInsertRepository.insertWithEntityManager(order);
            return userClient.getBill(order.getItems());
        }
        throw new OrderNotFoundException();
    }

    @Override
    public boolean giveFeedback(Long id, String feedback, Integer rating) throws OrderNotFoundException {
        Optional<Orders> ordersOptional = orderRepository.findById(id);
        if(ordersOptional.isPresent()){
            Orders order = ordersOptional.get();
            order.setFeedbackComments(feedback);
            order.setRating(rating);
            orderInsertRepository.insertWithEntityManager(order);
            return true;
        }
        throw new OrderNotFoundException();
    }
}
