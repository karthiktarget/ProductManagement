package com.example.SimpleWebApp.service;

import com.example.SimpleWebApp.model.Product;
import com.example.SimpleWebApp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository repo;
    //List<Product> products = new ArrayList<>(Arrays.asList(new Product(1,"Nokia",10000), new Product(2,"Iphone",50000), new Product(3,"Samsung", 70000)));
    public List<Product> getProducts()
    {
        return repo.findAll();
    }

    public Product getProductById(int prodID) {
        return repo.findById(prodID).orElse(null);
    }
    public void addProduct(Product prod){
        repo.save(prod);
    }

    public boolean updateProduct(int prodID,Product updatedprod) {
        if(repo.existsById(prodID))
        {
            updatedprod.setProdID(prodID);
            repo.save(updatedprod);
            return true;
        }
        return false;
    }

    public boolean deleteProduct(int prodID) {
        if(repo.existsById(prodID))
        {
            repo.deleteById(prodID);
            return true;
        }
        return false;
    }
}
