package com.company.M2ChallengeAyeleDereje.controller;

import com.company.M2ChallengeAyeleDereje.model.Maths;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MathsController.class)
public class MathsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper  mapper = new ObjectMapper();
    
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void shouldReturnNewAddOnPostRequest() throws Exception {
        Maths inputMaths = new Maths();
        inputMaths.setOperand1(100);
        inputMaths.setOperand2(200);
        inputMaths.setOperation("add");
        inputMaths.setAnswer(300);
        String inputJson = mapper.writeValueAsString(inputMaths);

        Maths outputMaths = new Maths();
        outputMaths.setOperand1(100);
        outputMaths.setOperand2(200);
        outputMaths.setOperation("add");
        outputMaths.setAnswer(300);
        String outputJson = mapper.writeValueAsString(outputMaths);

        mockMvc.perform(post("/add")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)

        )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void ShouldReturnNewDivideOnPostRequest() throws Exception {
        Maths inputMaths = new Maths();
        inputMaths.setOperand1(500);
        inputMaths.setOperand2(250);
        inputMaths.setOperation("divide");
        inputMaths.setAnswer(2);
        String inputJson = mapper.writeValueAsString(inputMaths);

        Maths outputMaths = new Maths();
        outputMaths.setOperand1(500);
        outputMaths.setOperand2(250);
        outputMaths.setOperation("divide");
        outputMaths.setAnswer(2);
        String outputJson = mapper.writeValueAsString(outputMaths);

        mockMvc.perform(post("/divide")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)

                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));

    }


    @Test
    public void shouldReturnNewMultiplyOnPostRequest() throws Exception{

        Maths inputMaths = new Maths();
        inputMaths.setOperand1(20);
        inputMaths.setOperand2(10);
        inputMaths.setOperation("multiply");
        inputMaths.setAnswer(200);
        String inputJson = mapper.writeValueAsString(inputMaths);

        Maths outputMaths = new Maths();
        outputMaths.setOperand1(20);
        outputMaths.setOperand2(10);
        outputMaths.setOperation("multiply");
        outputMaths.setAnswer(200);
        String outputJson = mapper.writeValueAsString(outputMaths);

        mockMvc.perform(post("/multiply")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)

                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));

    }

    @Test
    public void shouldReturnSubtractOnPostRequest() throws Exception{

        Maths inputMaths = new Maths();
        inputMaths.setOperand1(100);
        inputMaths.setOperand2(70);
        inputMaths.setOperation("subtract");
        inputMaths.setAnswer(30);
        String inputJson = mapper.writeValueAsString(inputMaths);

        Maths outputMaths = new Maths();
        outputMaths.setOperand1(100);
        outputMaths.setOperand2(70);
        outputMaths.setOperation("subtract");
        outputMaths.setAnswer(30);
        String outputJson = mapper.writeValueAsString(outputMaths);

        mockMvc.perform(post("/subtract")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)

                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

}