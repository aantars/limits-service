package com.adolfo.microcloud.limitsservice.service;

import com.adolfo.microcloud.limitsservice.entity.Limits;
import com.adolfo.microcloud.limitsservice.repository.LimitsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class LimitsService {

    private LimitsRepository limitsRepository;

    public LimitsService(LimitsRepository limitsRepository) {
        this.limitsRepository = limitsRepository;
    }

    public List<Limits> findAll() {

        return limitsRepository.findAll();
    }
}
