package com.workit.test.entity;

import java.util.Objects;

public class Product {
    private int id;
    private String name;
    private float price;
    private String category;
    private int site_id;

    public Product() {
    }

    public Product(int id, String name, float price, String category, int site_id) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.site_id = site_id;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                Float.compare(product.price, price) == 0 &&
                site_id == product.site_id &&
                Objects.equals(name, product.name) &&
                Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, category, site_id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getSite_id() {
        return site_id;
    }

    public void setSite_id(int site_id) {
        this.site_id = site_id;
    }
}
