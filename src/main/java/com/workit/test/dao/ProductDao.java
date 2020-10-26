package com.workit.test.dao;

import com.workit.test.entity.Product;
import com.workit.test.mapper.JsonToProductMapper;
import com.workit.test.utils.FileManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {

    private final FileManager fileManager;
    private final JsonToProductMapper jsonToProductMapper;
    private final String pathOfJsonProduct;

    public ProductDao(final FileManager fileManager,
                      final JsonToProductMapper jsonToProductMapper,
                      @Value("${path.of.product.file}") final String pathOfJsonProduct) {
        this.fileManager = fileManager;
        this.jsonToProductMapper = jsonToProductMapper;
        this.pathOfJsonProduct = pathOfJsonProduct;
    }

    public List<Product> getProductsFromFile() {
        String productsAsJson = fileManager.readFile(pathOfJsonProduct);

        return jsonToProductMapper.apply(productsAsJson);
    }
}
