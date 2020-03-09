package com.tvh.bootcamp.infrastructure;

import java.util.List;

import com.tvh.bootcamp.domain.Employee;
import com.tvh.bootcamp.domain.Role;
import com.tvh.bootcamp.infrastructure.EmployeeRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("usaEmployeeRepository")
@Profile("usa")
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
