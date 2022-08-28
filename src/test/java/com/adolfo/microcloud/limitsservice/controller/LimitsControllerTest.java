package com.adolfo.microcloud.limitsservice.controller;

import com.adolfo.microcloud.limitsservice.entity.Limits;
import com.adolfo.microcloud.limitsservice.service.LimitsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class LimitsControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private LimitsService limitsService;

    @Test
    public void retrieveLimitsTest() throws Exception{
        List<Limits> initialLimitsList = new ArrayList<Limits>();
        Limits firstLimit = new Limits(3,7);
        Limits secondLimit = new Limits(1,9);
        initialLimitsList= Arrays.asList(firstLimit,secondLimit);
        when(limitsService.findAll()).thenReturn(initialLimitsList);

        mockMvc.perform(MockMvcRequestBuilders.get("/limits")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$",hasSize(2))).andDo(print());
    }

}
