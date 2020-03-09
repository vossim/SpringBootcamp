package com.tvh.bootcamp.api.web.facade.internal;

import java.util.List;
import java.util.stream.Collectors;

import com.tvh.bootcamp.api.web.facade.dto.EmployeeDTO;
import com.tvh.bootcamp.application.EmployeeService;
import com.tvh.bootcamp.domain.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeFacade {
    private final EmployeeService service;
    private final EmployeeDTOAssembler assembler;

    public List<EmployeeDTO> getEmployeesWithRole(Role role) {
        return service.getEmployeesWithRole(role).stream().map(assembler::toDto).collect(Collectors.toList());
    }

    public List<EmployeeDTO> getAllEmployees() {
        return service.getAllEmployees().stream().map(assembler::toDto).collect(Collectors.toList());
    }
}
