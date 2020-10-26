package com.workit.test.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.workit.test.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;
import java.util.function.Function;

@Component
public class JsonToProductMapper implements Function<String, List<Product>> {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonToProductMapper.class);

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<Product> apply(String jsonAsString) {

        try {
            return objectMapper.readValue(jsonAsString, new TypeReference<List<Product>>() {});
        } catch (JsonProcessingException e) {
            LOGGER.error("Unable to serialize json : [{}]", jsonAsString, e);
        }

        return null;
    }
}
