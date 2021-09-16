package kea.ovelser.demo.controller;

import kea.ovelser.demo.models.Product;
import kea.ovelser.demo.services.ProductService;
import kea.ovelser.demo.services.ProductServiceJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebShopController {
    ProductService service = new ProductService();
    @Autowired
    ProductServiceJpa jpaService = new ProductServiceJpa();


    @GetMapping(value = "/web-shop")
    public String showWebShop(Model model){
        model.addAttribute("allProducts", jpaService.getAllProduct());
        return "web-shop.html";
    }

    @GetMapping(value = "/product-form")
    public String getProductForm(){
        return "productform.html";
    }

    @PostMapping(value = "/productform")
    public String projectForm(@RequestParam("name") String name, @RequestParam("price") int price) {
        jpaService.makeProduct(name, price);
        return "redirect:/web-shop";
    }

    @PostMapping(value="/delete-product/{productID}")
    public String deleteVicProject(@PathVariable("productID") long productID) {
        jpaService.deleteProject(productID);
        return "redirect:/web-shop";
    }

    @GetMapping(value = "/update/{productID}")
    public String getProductUpdate(@PathVariable("productID") long productID,Model model){
        model.addAttribute("product", jpaService.getSpecificProduct(productID));
        return "update-product.html";
    }

    @PostMapping(value = "/update-product/")
    public String projectUpdate(@RequestParam("productID") long productID, @RequestParam("name") String name, @RequestParam("price") int price) {
        jpaService.updateProduct(productID, name, price);
        return "redirect:/web-shop";
    }
    // Mangler styling :)
}
