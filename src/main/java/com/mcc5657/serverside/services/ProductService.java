/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc5657.serverside.services;

import com.mcc5657.serverside.models.entities.Product;
import com.mcc5657.serverside.models.repos.ProductRepo;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MSI-JO
 */
@Service
@Transactional
public class ProductService {
    
    @Autowired
    private ProductRepo productRepo;
    
    public Product save(Product product){
        return productRepo.save(product);
    }
    
    public Product findOne(Long id){
        Optional<Product> product = productRepo.findById(id);
        if (!product.isPresent()) {
            return null;
        }
        return product.get();
    }
    
    public Iterable<Product> findAll(){
        return productRepo.findAll();
    }
    
    public void removeOne(Long id){
        productRepo.deleteById(id);
    }
    
    public List<Product> findByName(String name){
        return productRepo.findByNameContains(name);
    }
}
