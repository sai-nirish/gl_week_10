package com.example.greatlearning.service;

import com.example.greatlearning.entity.Items;
import com.example.greatlearning.model.Order;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    Optional<Items> getItemById(Integer id);

    List<Items> getItemsByIds(List<Integer> ids);

    List<Items> getAllItems();

    Integer getAggregatePrice(List<Integer> id);

    Integer getAggregatePriceFromOrder(List<Order> orders);
}
