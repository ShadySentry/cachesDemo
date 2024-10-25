package com.shadysentry.ehCache2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;

@SpringBootApplication
public class EhCache2Application implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(EhCache2Application.class, args);
    }

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void run(String... args) throws Exception {

        //This will hit the database
        employeeService.getEmployeeById(1L);

        //This will hit the cache - verify the message in console output
        employeeService.getEmployeeById(1L);
        employeeService.getEmployeeById(2L);
        employeeService.getEmployeeById(2L);
        employeeService.getEmployeeById(2L);
        employeeService.getEmployeeById(2L);
    }
}