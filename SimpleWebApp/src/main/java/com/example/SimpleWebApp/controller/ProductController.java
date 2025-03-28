package com.example.SimpleWebApp.controller;

import com.example.SimpleWebApp.model.Product;
import com.example.SimpleWebApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService services;
    @GetMapping
    public List<Product> getProduct()
    {
        return services.getProducts();
    }
    @GetMapping("/{prodID}")
    public Product getProductById(@PathVariable int prodID)
    {
        return services.getProductById(prodID);
    }
    @PostMapping
    public void addProduct(@RequestBody Product prod)
    {
        services.addProduct(prod);
    }
    @PutMapping("/{prodID}")
    public String updateProduct(@PathVariable int prodID,@RequestBody Product updatedprod)
    {
        boolean isUpdated = services.updateProduct(prodID, updatedprod);
        if(isUpdated)
        {
            return "Product successfully added";
        }
        else
        {
            return "Product not found";
        }
    }
    @DeleteMapping("/{prodID}")
    public  String deleteProduct(@PathVariable int prodID)
    {
        boolean isDeleted = services.deleteProduct(prodID);
        if(isDeleted)
        {
            return "Product is deleted";
        }
        else
        {
            return "Product not found";
        }
    }
}
