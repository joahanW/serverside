/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc5657.serverside.controllers;

import com.mcc5657.serverside.models.entities.Product;
import com.mcc5657.serverside.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author MSI-JO
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    @PostMapping
    public Product create(@RequestBody Product product){
        return productService.save(product);
    }
    
    @GetMapping
    public Iterable<Product> findAll(){
        return productService.findAll();
    }
    
    @GetMapping("/{id}")
    public Product findOne(@PathVariable Long id){
        return productService.findOne(id);
    }
    
    @PutMapping
    public Product update(@RequestBody Product product){
        return productService.save(product);
    }
    
    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable Long id){
        productService.removeOne(id);
    }
}
