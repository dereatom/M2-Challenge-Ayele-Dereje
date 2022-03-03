package com.company.M2ChallengeAyeleDereje.controller;

import com.company.M2ChallengeAyeleDereje.model.Month;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MonthConverterController.class)
public class MonthConverterControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    private ObjectMapper mapper = new ObjectMapper();
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void shouldReturnMonthByMonthNumber() throws Exception{
        Month outputMonth = new Month();
        outputMonth.setMonthNumber(5);
        outputMonth.setName("May");

        String outputJson = mapper.writeValueAsString(outputMonth);

        mockMvc.perform(get("/month/5"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

//    @Test
//    public void shouldReturn422Error() throws Exception{
//        Month outputMonth = new Month();
//        outputMonth.getMonthNumber();
//
//        String outputJson = mapper.writeValueAsString(outputMonth)
//
//        mockMvc.perform("")
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().json(outputJson));

//    }

    @Test
    public void shouldReturnRandomMonth() throws Exception{

        mockMvc.perform(get("/randomMonth"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.monthNumber").isNotEmpty())
                .andExpect(jsonPath("$.name").isNotEmpty());
    }
}