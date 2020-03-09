package com.tvh.bootcamp.api.web.facade.internal;

import java.util.List;

import com.tvh.bootcamp.api.web.facade.dto.EmployeeDTO;
import com.tvh.bootcamp.application.EmployeeService;
import com.tvh.bootcamp.domain.Employee;
import com.tvh.bootcamp.domain.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeFacadeTest {

    @Mock
    private EmployeeService service;

    private EmployeeDTOAssembler assembler = new EmployeeDTOAssembler();

    private EmployeeFacade facade;

    final Employee developer1 = createDeveloper("dev1");
    final Employee developer2 = createDeveloper("dev2");
    final Employee tester1 = new Employee("tst1", Role.TESTER, "AIR");

    @BeforeEach
    void setup() {
        facade = new EmployeeFacade(service, assembler);
    }

    @Test
    void getEmployeesWithRole() {
        final Role role = Role.DEVELOPER;
        when(service.getEmployeesWithRole(role)).thenReturn(List.of(developer1, developer2));

        List<EmployeeDTO> employeeDTOs = facade.getEmployeesWithRole(role);
        assertEquals("dev1", employeeDTOs.get(0).getName());
        assertEquals("dev2", employeeDTOs.get(1).getName());
    }

    @Test
    void getAllEmployees() {
        when(service.getAllEmployees()).thenReturn(List.of(developer1, tester1, developer2));

        List<EmployeeDTO> employeeDTOs = facade.getAllEmployees();
        assertEquals("dev1", employeeDTOs.get(0).getName());
        assertEquals("tst1", employeeDTOs.get(1).getName());
        assertEquals("dev2", employeeDTOs.get(2).getName());
    }

    private Employee createDeveloper(final String name) {
        return new Employee(name, Role.DEVELOPER, "AIR");
    }
}
