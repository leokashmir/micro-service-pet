package com.petz.api;

import org.springframework.boot.SpringApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import java.util.TimeZone;

@EnableJpaRepositories
@EnableTransactionManagement
@SpringBootApplication
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {

        TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
        SpringApplication.run(Application.class, args);

        LOGGER.info("Start Application  =====>   timeZone={}",  TimeZone.getDefault());
    }
}
