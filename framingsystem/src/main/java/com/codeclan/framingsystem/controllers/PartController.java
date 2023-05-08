package com.codeclan.framingsystem.controllers;

import com.codeclan.framingsystem.models.Part;
import com.codeclan.framingsystem.repositories.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PartController {

    @Autowired
    PartRepository partRepository;

    @GetMapping(value = "/parts")
    public ResponseEntity<List<Part>> getPart(
            @RequestParam(name = "id", required = false) Long id
    ){
        if (id != null){
            return new ResponseEntity<>(partRepository.findPartById(id), HttpStatus.OK);
        }

        return new ResponseEntity<>(partRepository.findAll(), HttpStatus.OK);
    }
}
