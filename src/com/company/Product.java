package com.company;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class Product {
    public int product_ID;
    private String product_category;
    private String product_name;
    private int price;
    private int weight;
   private int shelf_life;
   private String manufacturer;

    public Product() {
    }

    public Product(int product_ID, String product_category, String product_name, int price, int weight, int shelf_life, String manufacturer) {
        this.product_ID = product_ID;
        this.product_category = product_category;
        this.product_name = product_name;
        this.price = price;
        this.weight = weight;
        this.shelf_life = shelf_life;
        this.manufacturer = manufacturer;
    }

    public int getProduct_ID() {
        return product_ID;
    }

    public void setProduct_ID(int product_ID) {
        this.product_ID = product_ID;
    }

    public String getProduct_category() {
        return product_category;
    }

    public void setProduct_category(String product_category) {
        this.product_category = product_category;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getShelf_life() {
        return shelf_life;
    }

    public void setShelf_life(int shelf_life) {
        this.shelf_life = shelf_life;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

}
