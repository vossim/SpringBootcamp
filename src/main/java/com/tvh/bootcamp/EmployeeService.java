package com.tvh.bootcamp;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<Employee> getEmployeesWithRole(final Role role) {
        List<Employee> employees = employeeRepository.getEmployees();
        if (employees == null) {
            return List.of();
        }
        return employees.stream()
                .filter(employee -> role.equals(employee.getRole()))
                .collect(Collectors.toList());
    }
}
