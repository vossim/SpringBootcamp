package com.tvh.bootcamp;

public class EmployeeApplication {

    private final EmployeeService employeeService = new EmployeeService();

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
        new EmployeeApplication().run(args);
    }
}
