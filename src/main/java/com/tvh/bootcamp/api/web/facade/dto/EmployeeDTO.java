package com.tvh.bootcamp.api.web.facade.dto;

import com.tvh.bootcamp.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@Builder
public class EmployeeDTO {
    private String name;
    private Role role;
    private String workplace;
}
