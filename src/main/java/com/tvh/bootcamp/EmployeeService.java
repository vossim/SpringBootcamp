package com.tvh.bootcamp;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

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
