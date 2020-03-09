package com.tvh.bootcamp.infrastructure;

import java.util.List;

import com.tvh.bootcamp.domain.Employee;
import com.tvh.bootcamp.domain.Role;
import com.tvh.bootcamp.infrastructure.EmployeeRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("!usa")
public class TvhEmployeeRepository implements EmployeeRepository {
    @Override
    public List<Employee> getEmployees() {
        return List.of(
                new Employee("Chao", Role.SYSTEM_ENABLER, "AIR"),
                new Employee("Simon", Role.DEVELOPER, "AIR"),
                new Employee("Gwijde", Role.DEVELOPER, "WB3"),
                new Employee("Vishal", Role.TESTER, "AIR"));
    }
}
