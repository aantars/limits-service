package com.adolfo.microcloud.limitsservice.service;

import com.adolfo.microcloud.limitsservice.entity.Limits;
import com.adolfo.microcloud.limitsservice.repository.LimitsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class LimitsServiceTest {

    @Autowired
    private LimitsRepository limitsRepository;

    @Test
    public void findAllLimitsTest(){
        // AAA pattern -- Arrange -  Act -  Assert
        // Arrange - set up
        Limits firstLimits = new Limits(4,6);
        limitsRepository.save(firstLimits);
        LimitsService limitsService = new LimitsService(limitsRepository);

        // Act
        Limits retrievedLimit = limitsService.findAll().get(0);

        // Assert
        assertEquals(firstLimits.getMaximum(), retrievedLimit.getMaximum());
        assertEquals(firstLimits.getMinimum(), retrievedLimit.getMinimum());
    }
}
