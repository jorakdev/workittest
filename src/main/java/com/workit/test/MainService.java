package com.workit.test;

import com.workit.test.entity.Product;
import com.workit.test.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MainService {

    private final ProductService productService;

    public MainService(final ProductService productService) {
        this.productService = productService;
    }

    public void run() {
        Double averagePrice = productService.getProductsAveragePrice();
        Map<String, List<Product>> productByCategory = productService.getProductByCategory();
        List<Product> productsBelowPrice = productService.getProductWithPriceBelow(30);
        List<Product> sortProduct = productService.getSortedProducts();

    }
}
