package com.tvh.bootcamp.api.web.facade.internal;

import com.tvh.bootcamp.api.web.facade.dto.EmployeeDTO;
import com.tvh.bootcamp.domain.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDTOAssembler {
    public EmployeeDTO toDto(Employee employee) {
        if (employee == null) {
            return null;
        }
        return EmployeeDTO.builder()
                .name(employee.getName())
                .role(employee.getRole())
                .workplace(employee.getWorkplace())
                .build();
    }
}
