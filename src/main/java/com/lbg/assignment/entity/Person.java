package com.lbg.assignment.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table
@Data
public class Person {
    @Id
    private long id;
    private String firstName;
    private String lastName;
}