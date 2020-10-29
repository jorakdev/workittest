package com.workit.test;

import com.workit.test.entity.Product;
import com.workit.test.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApplicationTests {

    //@Autowired
    //C’est une annotation qui nous permet de faire l’injection de dépendances entre les beans de l’application
    // (Spring va tout faire), il suffit juste d’annoter un constructeur ou une méthode avec cette dernière.
    // et le conteneur Spring va faire la suite(La creation du bean, le chercher et l’injecter automatiquement…).
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductFactory productFactory;


    @Test
    void contextLoads() {
        assertNotNull(productService);
    }

    @Test
    void getProductsAveragePrice() {

        //given
        Double exepectedAvragePrice = Double.valueOf(48.142857142857146);

        //when
        Double averagePriceResult = productService.getProductsAveragePrice();

        //then
        assertEquals(exepectedAvragePrice, averagePriceResult);
    }

    @Test
    void getProductByCategory() {
        //given
        Map<String, List<Product>> exeptedProductByCategory = new HashMap<>();

        exeptedProductByCategory.put("Jeux vidéo", productFactory.createProducts());
        //when
        Map<String, List<Product>> productByCategory = productService.getProductByCategory();

        //then
        assertTrue(productByCategory.containsKey("Jeux vidéo"));
        assertEquals(14, productByCategory.get("Jeux vidéo").size());

    }

    @Test
    void getProductWithPriceBelow() {
        //given
        Product p1 = new Product(8, "Final Fantasy XV Day One Edition Jeu PS4", 10.0f, "Jeux vidéo", 20);
        List<Product> expectedlist = List.of(p1);

        //when
        List<Product> list = productService.getProductWithPriceBelow(20);

        //then
        assertEquals(expectedlist, list);
    }

    @Test
    void sortProducts() {
        //given
        List<Product> exceptedProduct = productFactory.createProducts();
        exceptedProduct.sort(Comparator.comparing(Product::getPrice));

        //when
        List<Product> sortedProducts = productService.getSortedProducts();

        //then
        assertEquals(exceptedProduct, sortedProducts);
    }

}
