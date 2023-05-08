package com.codeclan.framingsystem.controllers;

import com.codeclan.framingsystem.models.PresetPart;
import com.codeclan.framingsystem.repositories.PresetPartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PresetPartController {

    @Autowired
    PresetPartRepository presetPartRepository;

    @GetMapping(value = "/presetparts")
    public ResponseEntity<List<PresetPart>> getPart(
            @RequestParam(name = "id", required = false) Long id
    ){
        if (id != null){
            return new ResponseEntity<>(presetPartRepository.findPresetPartById(id), HttpStatus.OK);
        }

        return new ResponseEntity<>(presetPartRepository.findAll(), HttpStatus.OK);
    }
}
