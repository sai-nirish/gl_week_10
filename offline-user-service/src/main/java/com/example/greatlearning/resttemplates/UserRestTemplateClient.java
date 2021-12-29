package com.example.greatlearning.resttemplates;

import com.example.greatlearning.model.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.metadata.ItemMetadata;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class UserRestTemplateClient {

    @Autowired
    RestTemplate restTemplate;

    public List<Items> getItems(){
        String bseURL = "http://localhost:8080/users/items";
        ResponseEntity<Items[]> itemsResponse = restTemplate.getForEntity(bseURL, Items[].class);
        Items[] items = itemsResponse.getBody();
        return Arrays.asList(items);
    }

}
