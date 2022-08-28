package com.adolfo.microcloud.limitsservice.controller;

import com.adolfo.microcloud.limitsservice.entity.Limits;
import com.adolfo.microcloud.limitsservice.service.LimitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LimitsController {

    @Autowired
    LimitsService limitsService;

    @GetMapping("/limits")
    public ResponseEntity<List<Limits>> getAllLimits(){
        return new ResponseEntity<>(limitsService.findAll(), HttpStatus.OK);
    }
}
