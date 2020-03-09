package com.tvh.bootcamp;

import com.tvh.bootcamp.application.EmployeeService;
import com.tvh.bootcamp.configuration.MessageConfiguration;
import com.tvh.bootcamp.domain.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeApplication implements CommandLineRunner {

    private final MessageConfiguration messageConfiguration;

    private final EmployeeService employeeService;

    public EmployeeApplication(EmployeeService employeeService, MessageConfiguration messageConfiguration) {
        this.employeeService = employeeService;
        this.messageConfiguration = messageConfiguration;
    }

    public void run(String... args) {
        System.out.println(messageConfiguration.getWelcomeMessage());
        System.out.println(messageConfiguration.getDescription());
        System.out.println("-------------------------------------------");
        System.out.println("Listing all developers:");
        employeeService.getEmployeesWithRole(Role.DEVELOPER).forEach(System.out::println);
        System.out.println("-------------------------------------------");
        System.out.println("Listing all employees in AIR:");
        employeeService.getEmployeesInWorkplace("AIR").forEach(System.out::println);
        System.out.println("-------------------------------------------");
    }

    public static void main(String[] args) {
        SpringApplication.run(EmployeeApplication.class, args);
    }
}
