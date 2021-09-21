/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc5657.serverside.controller;

import com.mcc5657.serverside.model.Region;
import com.mcc5657.serverside.service.RegionService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
@RequestMapping("/api/region")
public class RegionController {

    private RegionService regionService;

    @Autowired
    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }
 
    @GetMapping
    public List<Region> getAll() {
        return regionService.getAll();
    }
    
    @PostMapping
    public Region create(@RequestBody Region region) {
        if (regionService.findByName(region.getName()) != null) {
            return null;
        }
        return regionService.create(region);
    }
    
    @GetMapping("/{id}")
    public Region findById(@PathVariable Long id){
        return regionService.findById(id);
    }
    
    @PutMapping
    public Region update(@RequestBody Region region) {
        if (regionService.findById(region.getId()) == null) {
            return null;
        }
        return regionService.create(region);
    }
    
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        regionService.deleteById(id);
    }
    
    @GetMapping("search/{name}")
    public List<Region> searchRegion(@PathVariable String name){
        return regionService.findByName(name);
    }
    
    //    @GetMapping("region/{nama}")
//    public String index(@PathVariable String nama) {
//        return "Hello bro " + nama;
//    }
//
//    @PostMapping("login")
//    public String login(@RequestBody HashMap<String, String> user) {
//        Map<String, String> admin = new HashMap<>();
//        admin.put("account", "admin");
//        admin.put("password", "admin");
//        if (user.get("account").equals(admin.get("account")) && user.get("password").equals(admin.get("password"))) {
//            return "Berhasil";
//        } else {
//            return "Gagal";
//        }
//    }
}
