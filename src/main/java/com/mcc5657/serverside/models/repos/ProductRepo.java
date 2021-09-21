/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc5657.serverside.models.repos;

import com.mcc5657.serverside.models.entities.Product;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author MSI-JO
 */
public interface ProductRepo extends CrudRepository<Product, Long>{
    List<Product> findByNameContains(String name);
}
