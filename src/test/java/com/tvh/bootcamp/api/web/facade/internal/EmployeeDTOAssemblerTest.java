package com.tvh.bootcamp.api.web.facade.internal;

import com.tvh.bootcamp.api.web.facade.dto.EmployeeDTO;
import com.tvh.bootcamp.domain.Employee;
import com.tvh.bootcamp.domain.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmployeeDTOAssemblerTest {

    private EmployeeDTOAssembler assembler = new EmployeeDTOAssembler();

    @Test
    void toDto_withNull() {
        Assertions.assertNull(assembler.toDto(null));
    }

    @Test
    void toDto() {
        final Employee employee = new Employee("dev", Role.DEVELOPER, "AIR");

        EmployeeDTO dto = assembler.toDto(employee);

        Assertions.assertEquals("dev", dto.getName());
        Assertions.assertEquals(Role.DEVELOPER, dto.getRole());
        Assertions.assertEquals("AIR", dto.getWorkplace());
    }
}
