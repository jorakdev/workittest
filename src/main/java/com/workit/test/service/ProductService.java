package com.workit.test.service;

import com.workit.test.dao.ProductDao;
import com.workit.test.entity.Product;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    private final ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    /**
     * @return average of product price
     */
    public Double getProductsAveragePrice() {
        List<Product> productsFromFile = productDao.getProductsFromFile();
        return Math.random();
    }

    /**
     * @return products group by category
     */
    public Map<String, List<Product>> getProductByCategory() {

        return Collections.emptyMap();
    }

    /**
     * @param price max price
     * @return filter products with price less than price parameter
     */
    public List<Product> getProductWithPriceBelow(double price) {

        return Collections.emptyList();
    }

    /**
     * @return ascendant sorted products
     */
    public List<Product> getSortedProducts() {

        return Collections.emptyList();
    }


}
