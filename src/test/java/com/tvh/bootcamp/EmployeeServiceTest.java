package com.tvh.bootcamp;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository repository;

    @InjectMocks
    private EmployeeService service;

    final Employee developer = createDeveloper("developer1");

    final Employee systemEnabler = new Employee("systemEnabler1", Role.SYSTEM_ENABLER, "workplace1");
    final Employee tester = new Employee("tester1", Role.TESTER, "workplace1");

    @Test
    void getEmployeesWithRole_nullList() {
        when(repository.getEmployees()).thenReturn(null);

        final List<Employee> employees = service.getEmployeesWithRole(Role.DEVELOPER);

        Assertions.assertEquals(0, employees.size());
    }

    @Test
    void getEmployeesWithRole_emptyList() {
        when(repository.getEmployees()).thenReturn(List.of());

        final List<Employee> employees = service.getEmployeesWithRole(Role.DEVELOPER);

        Assertions.assertEquals(0, employees.size());
    }

    @Test
    void getEmployeesWithRole_noDevelopers() {
        when(repository.getEmployees()).thenReturn(List.of(systemEnabler, tester));

        final List<Employee> employees = service.getEmployeesWithRole(Role.DEVELOPER);

        Assertions.assertEquals(0, employees.size());
    }

    @Test
    void getEmployeesWithRole_oneDeveloper() {
        when(repository.getEmployees()).thenReturn(List.of(developer, systemEnabler, tester));

        final List<Employee> employees = service.getEmployeesWithRole(Role.DEVELOPER);

        Assertions.assertEquals(1, employees.size());
        Assertions.assertEquals(developer, employees.get(0));
    }

    @Test
    void getEmployeesWithRole_multipleDevelopers() {
        Employee developer2 = createDeveloper("developer2");
        Employee developer3 = createDeveloper("Someone with a different name");
        when(repository.getEmployees()).thenReturn(List.of(developer, systemEnabler, tester, developer2, developer3));

        final List<Employee> employees = service.getEmployeesWithRole(Role.DEVELOPER);

        Assertions.assertEquals(3, employees.size());
        Assertions.assertEquals(List.of(developer, developer2, developer3), employees);
    }

    private Employee createDeveloper(final String name) {
        return new Employee(name, Role.DEVELOPER, "workplace1");
    }
}
