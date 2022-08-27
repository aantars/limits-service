package com.adolfo.microcloud.limitsservice.controller;

import com.adolfo.microcloud.limitsservice.entity.Limits;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LimitsControllerTest {

    @Mock
    LimitsController limitsController;

    @Test
    public void retrieveLimitsTest_simpleNoMock(){
       LimitsController limitsControllerSimple = new LimitsController();
       // ArrayList<Limits> limitsList = new ArrayList<Limits>();
        Limits createdLimits = new Limits(1,9);
        Limits retrievedLimits = limitsControllerSimple.retrieveLimits();
        assertEquals(retrievedLimits.getMinimum(), createdLimits.getMinimum());
    }


    @Test
    public void retrieveLimitsTest_mockedController(){
        Limits limit19 = new Limits(1,9);
     /*   Limits limit25= new Limits(2,5);
        Limits limit17 = new Limits(1,7);
        ArrayList<Limits> limitsList = new ArrayList<>();
        limitsList.addAll(Arrays.asList(limit17, limit19, limit25));*/

        when(limitsController.retrieveLimits()).thenReturn(limit19);

        Limits retrievedLimits = limitsController.retrieveLimits();

        assertThat(retrievedLimits.getMinimum()).isEqualTo(1);
    }

    public void retrieveLimitsTest_checkingHeaders(){
       /*
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Limits limit19 = new Limits(1,9);
        when(limitsController.retrieveLimits()).thenReturn(limit19);

        ResponseEntity<Object> responseEntity =limitsController.retrieveLimits();

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
        assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");
         */
    }
}
