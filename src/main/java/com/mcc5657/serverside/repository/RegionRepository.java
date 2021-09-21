/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc5657.serverside.repository;

import com.mcc5657.serverside.model.Region;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MSI-JO
 */
@Repository
public interface RegionRepository extends JpaRepository<Region, Long>{
    List<Region> findByNameEquals(String name);
}
