package com.x.ess.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author ppawlowski
 */
@SpringBootApplication
@ComponentScan({"com.x.ess.app", "com.x.ess.service"})
@EnableMongoRepositories("com.x.ess.dao.repository")
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

}
