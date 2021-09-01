package kea.ovelser.demo.repository;

import kea.ovelser.demo.models.Product;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class ProductRep {
    private String url;
    private String user;
    private String password;

    public ProductRep() {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("src/main/resources/application.properties"));
            this.url = prop.getProperty("url");
            this.user = prop.getProperty("user");
            this.password = prop.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Product> getAllProducts(){
        ArrayList<Product> allProducts = new ArrayList<Product>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
        }

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM products");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Product tmp = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3)
                );
                allProducts.add(tmp);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return allProducts;
    }

    public Product  getSpecificProduct(int productID) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
        }
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM products where product_id=?");
            stmt.setInt(1, productID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Product tmpProduct = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3)
                );
                return tmpProduct;
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void createProduct(Product product){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e) {
            System.out.println("There is no MySQL JDBC Driver?");
            e.printStackTrace();
        }

        try{
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO products (`name`, price) VALUES (?,?)");

            stmt.setString(1, product.getName());
            stmt.setInt(2, product.getPrice());
            stmt.executeUpdate();
            conn.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void updateProduct(int productID, String newName, int newPrice){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e) {
            System.out.println("There is no MySQL JDBC Driver?");
            e.printStackTrace();
        }

        try{
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement("UPDATE products SET `name` = ? , price = ? WHERE product_id = ?");

            stmt.setString(1, newName);
            stmt.setInt(2, newPrice);
            stmt.setInt(3, productID);
            stmt.executeUpdate();
            conn.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteProduct(int productID) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
        }

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement("Delete FROM products where product_id=?");
            stmt.setInt(1, productID);
            stmt.execute();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
