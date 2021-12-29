package com.example.greatlearning.serviceImpl;

import com.example.greatlearning.entity.Items;
import com.example.greatlearning.model.Order;
import com.example.greatlearning.repository.ItemsRepository;
import com.example.greatlearning.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ItemsServiceImpl implements ItemService {

    @Autowired
    ItemsRepository itemsRepository;

    @Override
    public Optional<Items> getItemById(Integer id) {
        return itemsRepository.findById(id);
    }

    @Override
    public List<Items> getItemsByIds(List<Integer> ids) {
        return itemsRepository.findAllById(ids);
    }

    @Override
    public List<Items> getAllItems() {
        List<Items> items = itemsRepository.findAll();
        log.info(String.valueOf(items));
        return items;
    }

    @Override
    public Integer getAggregatePrice(List<Integer> ids) {
        List<Items> items = this.getItemsByIds(ids);
        if(items.size() > 0 ){
            Integer totalPrice = 0;
            for (Items item : items) {
                totalPrice = totalPrice + item.getPrice();

            }
            return totalPrice;
        } else {
            throw new IllegalArgumentException("User ids not present");
        }
    }

    @Override
    public Integer getAggregatePriceFromOrder(List<Order> orders) {
        if(orders.size() > 0 ){
            Integer totalPrice = 0;
            for (Order order : orders) {
                Optional<Items> item = this.getItemById(order.getItemId());
                if (!item.isEmpty()) {
                    totalPrice = totalPrice + item.get().getPrice() * order.getQuantity();
                }

            }
            return totalPrice;
        }
        return 0;
    }
}
