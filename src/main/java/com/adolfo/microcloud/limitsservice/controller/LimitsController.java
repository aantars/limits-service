package com.adolfo.microcloud.limitsservice.controller;

import com.adolfo.microcloud.limitsservice.configuration.Configuration;
import com.adolfo.microcloud.limitsservice.entity.Limits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    @Autowired
    Configuration configuration;


    @GetMapping("/limits")
    public Limits retrieveLimits() {
        // TODO:  connect with the service to get the info
     //   int min = configuration.getMinimum();
     //   Limits retrievedLimits = new Limits(configuration.getMinimum(), configuration.getMaximum());
        Limits retrievedLimits = new Limits(1,9);
        return retrievedLimits;
    }
}
