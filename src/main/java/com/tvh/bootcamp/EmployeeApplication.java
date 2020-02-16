package com.tvh.bootcamp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan
public class EmployeeApplication {

    private final EmployeeService employeeService;

    public EmployeeApplication(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void run(String... args) {
        System.out.println("-------------------------------------------");
        System.out.println("Listing all developers:");
        employeeService.getEmployeesWithRole(Role.DEVELOPER).forEach(System.out::println);
        System.out.println("-------------------------------------------");
        System.out.println("Listing all employees in AIR:");
        employeeService.getEmployeesInWorkplace("AIR").forEach(System.out::println);
        System.out.println("-------------------------------------------");
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(EmployeeApplication.class);
        applicationContext.refresh();
        EmployeeApplication application = applicationContext.getBean(EmployeeApplication.class);
        application.run(args);
    }
}
