package kea.ovelser.demo.services;

import kea.ovelser.demo.models.Product;
import kea.ovelser.demo.repository.ProductRep;

import java.util.ArrayList;

public class ProductService {
    private ProductRep productRep;

    public ProductService(){
        this.productRep = new ProductRep();
    }

    public ArrayList<Product> getAllProducts(){
        ArrayList<Product> allProducts = new ArrayList<>();
        for (int i = 0; i < productRep.getAllProducts().size(); i++) {
            allProducts.add(productRep.getAllProducts().get(i));
        }
        return allProducts;
    }

    public Product getspecificProduct(int id){
        return productRep.getSpecificProduct(id);
    }

    public void makeProduct(String name, int price){
        Product product = new Product(name, price);
            productRep.createProduct(product);

    }

    public void deleteProduct(int productID){
        productRep.deleteProduct(productID);
    }

    public void updateProduct(int productID, String name, int price){
        productRep.updateProduct(productID, name, price);
    }

}
