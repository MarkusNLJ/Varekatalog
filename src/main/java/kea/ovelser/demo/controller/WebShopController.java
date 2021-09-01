package kea.ovelser.demo.controller;

import kea.ovelser.demo.models.Product;
import kea.ovelser.demo.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebShopController {
    ProductService service = new ProductService();


    @GetMapping(value = "/web-shop")
    public String showWebShop(Model model){
        model.addAttribute("allProducts", service.getAllProducts());
        return "web-shop.html";
    }

    @GetMapping(value = "/product-form")
    public String getProductForm(){
        return "productform.html";
    }

    @PostMapping(value = "/productform")
    public String projectForm(@RequestParam("name") String name, @RequestParam("price") int price) {
        service.makeProduct(name, price);
        return "redirect:/web-shop";
    }

    @GetMapping(value="/delete-product/{productID}")
    public String deleteVicProject(@PathVariable("productID") int productID) {
        service.deleteProduct(productID);
        return "redirect:/web-shop";
    }

    @GetMapping(value = "/update/{productID}")
    public String getProductUpdate(@PathVariable("productID") int productID,Model model){
        model.addAttribute("product", service.getspecificProduct(productID));
        return "update-product.html";
    }

    @PostMapping(value = "/update-product/")
    public String projectUpdate(@RequestParam("productID") int productID, @RequestParam("name") String name, @RequestParam("price") int price) {
        service.updateProduct(productID, name, price);
        return "redirect:/web-shop";
    }
    // Mangler delete, update og styling :)
}
