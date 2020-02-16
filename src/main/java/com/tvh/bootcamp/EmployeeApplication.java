package com.tvh.bootcamp;

public class EmployeeApplication {

    private final EmployeeService employeeService = new EmployeeService();

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
        new EmployeeApplication().run(args);
    }
}
