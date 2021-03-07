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



    public static void addNewP(Product p){
        Main m =new Main();
        m.getCon(); //connecting with database
        try {
            //make request
            PreparedStatement ps=m.con.prepareStatement("insert into ANVAR(product_ID,product_category,product_name,price,weight,shelf_life,manufacturer)" +
                    "values(?,?,?,?,?,?,?)");
            //add values
            ps.setInt(1,p.product_ID);
            ps.setString(2,p.product_category);
            ps.setString(3,p.product_name);
            ps.setInt(4,p.price);
            ps.setInt(5,p.weight);
            ps.setInt(6,p.shelf_life);
            ps.setString(7,p.manufacturer);
            ps.executeUpdate();
            ps.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //method to delete product by id
    public static void deleteProduct(int product_ID){
        Main m =new Main();
        m.getCon(); //get connection
        try{
            PreparedStatement ps=m.con.prepareStatement("delete from ANVAR where product_ID=?");
            ps.setInt(1,product_ID);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void productInfo(){ //especially here data from "Company" table
        Main m =new Main();
        m.getCon();
        try {
            //make request to database
            PreparedStatement preparedStatement=m.con.prepareStatement("select *from ANVAR");
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                //get data from all columns
                int product_ID=resultSet.getInt("product_ID");
                String product_category=resultSet.getString("product_category");
                String product_name=resultSet.getString("product_name");
                String manufacturer=resultSet.getString("manufacturer");
                int price=resultSet.getInt("price");
                int weight=resultSet.getInt("weight");
                int shelf_life=resultSet.getInt("shelf_life");
                System.out.println("product_ID" + ":"+product_ID + ", " + "product_category" + ":" + product_category
                        + ", " + "product_name" +  ":" + product_name + ", " + "manufacturer" + ":" + manufacturer + ", " + "price" + ":" + price +", " + "weight" + ":"+ weight
                        + ", " + "shelf_life" + ":" + shelf_life);
                preparedStatement.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
//product_ID,product_category,product_name,price,weight,shelf_life,manufacturer