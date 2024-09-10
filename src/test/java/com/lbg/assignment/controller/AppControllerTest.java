package com.lbg.assignment.controller;

import com.lbg.assignment.config.Responses;
import com.lbg.assignment.entity.Person;
import com.lbg.assignment.repository.PersonRepository;
import com.lbg.assignment.service.StateManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({AppController.class, StateManager.class, Responses.class})
@TestPropertySource(properties = "application.response=Hi")
public class AppControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PersonRepository personRepository;

    @Test
    void validateSetStatusEndpoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/setStatus").param("status", "healthy")) // Simulate a GET request to /hello
                .andExpect(status().isOk()) // Expect 200 OK status
                .andExpect(content().string("Update complete")); // Expect content to match "Hello, World!"
    }

    @Test
    void validatePersonEndpoint() throws Exception {
        Person p = new Person();
        p.setId(1);
        p.setFirstName("Victor");
        p.setLastName("Hugo");
        when(personRepository.findById(1L)).thenReturn(Optional.of(p));
        mockMvc.perform(MockMvcRequestBuilders.get("/getEmployee").param("id", "ABC")) // Simulate a GET request to /hello
                .andExpect(status().isOk()) // Expect 200 OK status
                .andExpect(content().json("{\"id\":1,\"firstName\":\"Victor\",\"lastName\":\"Hugo\"}", false)); // Expect content to match "Hello, World!"
    }
}
