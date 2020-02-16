package com.tvh.bootcamp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeApplication implements CommandLineRunner {

    private final EmployeeService employeeService;

    public EmployeeApplication(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void run(String... args) {
        System.out.println("-------------------------------------------");
        System.out.println("Listing all developers:");
        employeeService.printEmployeesWithRole(Role.DEVELOPER);
        System.out.println("-------------------------------------------");
        System.out.println("Listing all employees in AIR:");
        employeeService.printEmployeesInWorkplace("AIR");
        System.out.println("-------------------------------------------");
    }

    public static void main(String[] args) {
        SpringApplication.run(EmployeeApplication.class, args);
    }
}
