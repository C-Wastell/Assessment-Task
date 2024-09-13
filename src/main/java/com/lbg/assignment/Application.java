package com.lbg.assignment;

import com.lbg.assignment.controller.AppController;
import com.lbg.assignment.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    AppController appController;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ResponseEntity<String> status = appController.setStatus("Okay");
        System.out.println("Status set to: " + status);
        ResponseEntity<Person> p1 = appController.getEmployee(1L);
        System.out.println("Person returned: " + p1.getBody().getFirstName());

    }
}