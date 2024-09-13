package com.lbg.assignment.service;

import com.lbg.assignment.config.Responses;
import com.lbg.assignment.entity.Person;
import com.lbg.assignment.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

//@service
public class StateManager {

    @Autowired
    Responses response;

    @Autowired
    PersonRepository personRepository;

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

    public String getStatus() {
        return status;
    }
}

