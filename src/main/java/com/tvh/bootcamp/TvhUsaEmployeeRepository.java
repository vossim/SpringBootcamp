package com.tvh.bootcamp;

import java.util.List;

public class TvhUsaEmployeeRepository implements EmployeeRepository {
    @Override
    public List<Employee> getEmployees() {
        return List.of(
                new Employee("Emma", Role.SYSTEM_ENABLER, "AIR"),
                new Employee("Donald", Role.DEVELOPER, "AIR"),
                new Employee("William", Role.DEVELOPER, "WB3"),
                new Employee("Olivia", Role.TESTER, "AIR"));
    }
}
