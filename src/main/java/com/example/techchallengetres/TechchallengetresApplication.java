package com.example.techchallengetres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class TechchallengetresApplication {

    public static void main(String[] args) {
        SpringApplication.run(TechchallengetresApplication.class, args);
    }

}
