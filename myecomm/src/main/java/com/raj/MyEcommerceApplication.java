package com.raj;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class MyEcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyEcommerceApplication.class, args);
    }

    @Bean
    public Gson gson() {
        return new GsonBuilder().registerTypeAdapter(Date.class, new DateLongFormatTypeAdapter()).create();
    }
}
