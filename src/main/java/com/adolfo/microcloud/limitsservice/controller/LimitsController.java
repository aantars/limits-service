package com.adolfo.microcloud.limitsservice.controller;

import com.adolfo.microcloud.limitsservice.LimitsServiceApplication;
import com.adolfo.microcloud.limitsservice.entity.Limits;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class LimitsController {

    @GetMapping("/limits")
    public Limits retrieveLimits() {
        // TODO:  connect with the service to get the info
        Limits retrievedLimits = new Limits(1,9);
        return retrievedLimits;
    }
}
