/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc5657.serverside.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author MSI-JO
 */
@RestController
@RequestMapping("api")
public class RegionController {

    @GetMapping("region/{nama}")
    public String index(@PathVariable String nama) {
        return "Hello bro " + nama;
    }

    @PostMapping("login")
    public String login(@RequestBody HashMap<String, String> user) {
        Map<String, String> admin = new HashMap<>();
        admin.put("account", "admin");
        admin.put("password", "admin");
        if (user.get("account").equals(admin.get("account")) && user.get("password").equals(admin.get("password"))) {
            return "Berhasil";
        } else {
            return "Gagal";
        }
    }
}
