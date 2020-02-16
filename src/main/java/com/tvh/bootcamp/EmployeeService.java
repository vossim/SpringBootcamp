package com.tvh.bootcamp;

public class EmployeeService {
    private EmployeeRepository employeeRepository = new TvhEmployeeRepository();

    public void printEmployeesWithRole(Role role) {
        employeeRepository.getEmployees().stream()
                .filter(employee -> role.equals(employee.getRole()))
                .forEach(System.out::println);
    }

    public void printEmployeesInWorkplace(String workplace) {
        employeeRepository.getEmployees().stream()
                .filter(employee -> workplace.equals(employee.getWorkplace()))
                .forEach(System.out::println);
    }
}
