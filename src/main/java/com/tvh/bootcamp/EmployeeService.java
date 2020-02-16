package com.tvh.bootcamp;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {
    private EmployeeRepository employeeRepository = new TvhEmployeeRepository();

    public List<Employee> getEmployeesWithRole(Role role) {
        return employeeRepository.getEmployees().stream()
                .filter(employee -> role.equals(employee.getRole()))
                .collect(Collectors.toList());
    }

    public List<Employee> getEmployeesInWorkplace(String workplace) {
        return employeeRepository.getEmployees().stream()
                .filter(employee -> workplace.equals(employee.getWorkplace()))
                .collect(Collectors.toList());
    }
}
