package kea.ovelser.demo.services;

import kea.ovelser.demo.models.Product;
import kea.ovelser.demo.repository.ProductRepInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class ProductServiceJpa {
    @Autowired
    private ProductRepInterface productRepInterface;

    public ArrayList<Product> getAllProduct(){
        ArrayList<Product> allProducts = new ArrayList<>();
        productRepInterface.findAll().forEach(allProducts::add);
       return allProducts;
    }

    public Product getSpecificProduct(long id){
        return productRepInterface.findProductById(id);
    }

    public void makeProduct(String name, int price){
        Product tmp = new Product(name, price);
        productRepInterface.save(tmp);
    }

    public void deleteProject(long id){
        productRepInterface.deleteById(id);
    }

    public void updateProduct(long id, String name, int price){
        Product tmp = productRepInterface.findProductById(id);
        tmp.setName(name);
        tmp.setPrice(price);
        productRepInterface.save(tmp);
    }
}
