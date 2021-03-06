package kea.ovelser.demo.models;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "id", nullable = false, updatable = false)
    private long id;
    //@Size( , message="Navnet må højst være 20 tegn") kan bestemme min og max størrelse på string
    private String name;
    //@Min() minimum beløb tal
    private int price;



    public Product(long id, String name, int price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(String name, int price){
        this.name = name;
        this.price = price;
    }

    public Product() {

    }

    //---------------------------||Getters||---------------------------//
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
    //---------------------------||Setters||---------------------------//

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
