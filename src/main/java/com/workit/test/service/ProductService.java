package com.workit.test.service;

import com.workit.test.dao.ProductDao;
import com.workit.test.entity.Product;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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
        return productsFromFile.stream().mapToDouble(Product::getPrice).average().getAsDouble();
    }

    /**
     * @return products group by category
     */
    public Map<String, List<Product>> getProductByCategory() {
        Map<String, List<Product>> productByCategory = new HashMap<>();
        for (Product p : productDao.getProductsFromFile()) {
            List<Product> listOfProduct = productByCategory.getOrDefault(p.getCategory(), new ArrayList<>());
            listOfProduct.add(p);
            productByCategory.put(p.getCategory(), listOfProduct);
        }
        return productByCategory;
    }

    /**
     * @param price max price
     * @return filter products with price less than price parameter
     */
    public List<Product> getProductWithPriceBelow(double price) {
        List<Product> productsFromFile = productDao.getProductsFromFile();
        return productsFromFile.stream().filter(p -> p.getPrice() < price).collect(Collectors.toList());
    }

    /**
     * @return ascendant sorted products
     */
    public List<Product> getSortedProducts() {
        List<Product> productsFromFile = productDao.getProductsFromFile();
        return productsFromFile.stream().sorted(Comparator.comparing(Product::getPrice)).collect(Collectors.toList());
    }
}
