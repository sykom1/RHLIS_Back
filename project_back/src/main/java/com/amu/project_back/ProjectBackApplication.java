package com.amu.project_back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = ProjectBackApplication.class)
@EntityScan(basePackageClasses = ProjectBackApplication.class)
@EnableTransactionManagement
@EnableScheduling
public class ProjectBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectBackApplication.class, args);
    }

}
