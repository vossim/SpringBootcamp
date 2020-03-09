package com.tvh.bootcamp.api.web;

import java.util.List;
import java.util.Optional;

import com.tvh.bootcamp.api.web.facade.dto.EmployeeDTO;
import com.tvh.bootcamp.api.web.facade.internal.EmployeeFacade;
import com.tvh.bootcamp.domain.Role;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {
    @Mock
    private EmployeeFacade facade;

    @InjectMocks
    private EmployeeController controller;

    final List<EmployeeDTO> employeeDTOs = List.of(new EmployeeDTO("dev1", Role.DEVELOPER, "AIR"));

    @Test
    void getAllEmployees() {
        when(facade.getAllEmployees()).thenReturn(employeeDTOs);

        final List<EmployeeDTO> actualDTOs = controller.getEmployees(Optional.empty());

        assertSame(employeeDTOs, actualDTOs);
        verify(facade, never()).getEmployeesWithRole(any());
    }

    @Test
    void getAllEmployees_withRole() {
        final Role role = Role.DEVELOPER;
        when(facade.getEmployeesWithRole(role)).thenReturn(employeeDTOs);

        final List<EmployeeDTO> actualDTOs = controller.getEmployees(Optional.of(role));

        assertSame(employeeDTOs, actualDTOs);
        verify(facade, never()).getAllEmployees();
    }

    @Test
    void getAllEmployees_withRole_emptyList() {
        final Role role = Role.DEVELOPER;
        List<EmployeeDTO> emptyList = List.of();
        when(facade.getEmployeesWithRole(role)).thenReturn(emptyList);

        final List<EmployeeDTO> actualDTOs = controller.getEmployees(Optional.of(role));

        assertSame(emptyList, actualDTOs);
        verify(facade, never()).getAllEmployees();
    }
}
