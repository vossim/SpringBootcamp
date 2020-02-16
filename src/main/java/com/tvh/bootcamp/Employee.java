package com.tvh.bootcamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Employee {
    private String name;
    private Role role;
    private String workplace;
}
