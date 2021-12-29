package com.example.greatlearning.model;

import com.example.greatlearning.entity.Orders;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Converter(autoApply = true)
public class JpaConverterJson implements AttributeConverter<List<Order>, String> {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(List<Order> meta) {
        try {
            return objectMapper.writeValueAsString(meta);
        } catch (JsonProcessingException ex) {
            return null;
            // or throw an error
        }
    }

    @Override
    public List<Order> convertToEntityAttribute(String dbData) {
        try {
            if(dbData != null){
                Order[] orders = objectMapper.readValue(dbData, Order[].class);
                if(orders != null){
                    return Arrays.asList(orders);
                }
                return null;
            }
            return null;
        } catch (IOException ex) {
            // logger.error("Unexpected IOEx decoding json from database: " + dbData);
            return null;
        }
    }

}
