package com.tvh.bootcamp.api.web;

import java.util.List;
import java.util.Optional;

import com.tvh.bootcamp.api.web.facade.dto.EmployeeDTO;
import com.tvh.bootcamp.api.web.facade.internal.EmployeeFacade;
import com.tvh.bootcamp.domain.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeFacade facade;

    @GetMapping
    public List<EmployeeDTO> getEmployees(@RequestParam final Optional<Role> role) {
        if (role.isPresent()) {
            return facade.getEmployeesWithRole(role.get());
        }
        return facade.getAllEmployees();
    }
}
