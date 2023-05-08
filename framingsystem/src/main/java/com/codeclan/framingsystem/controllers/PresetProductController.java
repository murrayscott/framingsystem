package com.codeclan.framingsystem.controllers;

import com.codeclan.framingsystem.models.PresetProduct;
import com.codeclan.framingsystem.repositories.PresetProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PresetProductController {

    @Autowired
    PresetProductRepository presetProductRepository;

    @GetMapping(value = "/presetproducts")
    public ResponseEntity<List<PresetProduct>> getPresetProducts(
            @RequestParam(name = "id", required = false) Long id
    ){
        if (id != null){
            return new ResponseEntity<>(presetProductRepository.findPresetProductById(id), HttpStatus.OK);
        }

        return new ResponseEntity<>(presetProductRepository.findAll(), HttpStatus.OK);
    }
}
