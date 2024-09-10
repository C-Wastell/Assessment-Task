package com.lbg.assignment.service;

import com.lbg.assignment.config.Responses;
import com.lbg.assignment.entity.Person;
import com.lbg.assignment.repository.PersonRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class StateManager {

    @Autowired
    Responses response;

    @Autowired
    PersonRepository personRepository;

    @Getter
    private String status;

    public void updateStatus(String status){
            this.status = status;
    }

    public String getResponse(){
        return response.getResponse();
    }

    public Person getPersonById(Long id){
        Optional<Person> p = personRepository.findById(id);
        return p.orElse(null);
    }
}

