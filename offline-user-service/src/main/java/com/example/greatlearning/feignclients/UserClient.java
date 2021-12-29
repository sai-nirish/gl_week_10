package com.example.greatlearning.feignclients;


import com.example.greatlearning.model.Items;
import com.example.greatlearning.model.Order;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(url = "http://localhost:8080/", name = "users")
public interface UserClient {

    @RequestMapping(method = RequestMethod.GET, value = "users/items")
    @Headers("Content-Type: application/json")
    public List<Items> getItems();

    @RequestMapping(method = RequestMethod.POST, value = "users/bill/multiple-quantity")
//    @Headers({"Content-Type: application/json", "user-agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36"})
    @Headers("Content-Type: application/json")
    public Integer getBill(List<Order> orders);
}
