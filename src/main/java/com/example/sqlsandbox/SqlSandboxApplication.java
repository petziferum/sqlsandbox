package com.example.sqlsandbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan
@EnableJpaRepositories(basePackages = "com.example.sqlsandbox")
public class SqlSandboxApplication {

    public static void main(String[] args) {
        SpringApplication.run(SqlSandboxApplication.class, args);
    }

}
