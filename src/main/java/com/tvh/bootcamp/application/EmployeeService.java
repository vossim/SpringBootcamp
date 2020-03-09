package com.tvh.bootcamp.application;

import java.util.List;
import java.util.stream.Collectors;

import com.tvh.bootcamp.domain.Employee;
import com.tvh.bootcamp.domain.Role;
import com.tvh.bootcamp.infrastructure.EmployeeRepository;
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

    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeRepository.getEmployees();
        if (employees == null) {
            return List.of();
        }
        return employees;
    }
}
