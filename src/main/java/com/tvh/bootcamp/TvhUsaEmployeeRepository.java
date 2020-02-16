package com.tvh.bootcamp;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("usaEmployeeRepository")
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
