package com.lbg.assignment.controller;

import com.lbg.assignment.entity.Person;
import com.lbg.assignment.service.StateManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    StateManager stateManager;

    @GetMapping("/setStatus")
        public ResponseEntity<String> setStatus(@RequestParam(name = "status") String status) {
        stateManager.updateStatus(status);
        return new ResponseEntity<>(stateManager.getResponse(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getEmployee")
    public ResponseEntity<String> setStatus(@RequestParam(name = "id") Long id) {
        Person p = stateManager.getPersonById(id);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }
}
