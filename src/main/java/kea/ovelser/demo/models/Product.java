package kea.ovelser.demo.models;

public class Product {
    private int id;
    private String name;
    private int price;


    public Product(int id, String name, int price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(String name, int price){
        this.name = name;
        this.price = price;
    }

    //---------------------------||Getters||---------------------------//
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
    //---------------------------||Setters||---------------------------//

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
