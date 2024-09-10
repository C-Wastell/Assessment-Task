package com.lbg.assignment.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class Responses {

    @Value("${application.responses}")
    private String response;

}
