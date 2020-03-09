package com.tvh.bootcamp.infrastructure;

import java.util.List;

import com.tvh.bootcamp.domain.Employee;

public interface EmployeeRepository {
    List<Employee> getEmployees();
}
