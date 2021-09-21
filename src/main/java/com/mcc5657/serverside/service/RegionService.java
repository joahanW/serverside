/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc5657.serverside.service;

import com.mcc5657.serverside.model.Region;
import com.mcc5657.serverside.repository.RegionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author MSI-JO
 */
@Service
public class RegionService {

    private RegionRepository regionRepository;

    @Autowired
    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    // See All Data
    public List<Region> getAll() {
        return regionRepository.findAll();
    }

    // Create data
    public Region create(Region region) {
        return regionRepository.save(region);
    }

    // findOne data
    public Region findById(long id) {
        Optional<Region> region = regionRepository.findById(id);
        if (!region.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Data tidak ditemukan");
        }
        return region.get();
//        return regionRepository.findById(id).get();
    }

    // DeleteOne data
    public void deleteById(Long id) {
        regionRepository.deleteById(id);
    }

    public List<Region> findByName(String name) {
        return regionRepository.findByNameEquals(name);
    }
}
