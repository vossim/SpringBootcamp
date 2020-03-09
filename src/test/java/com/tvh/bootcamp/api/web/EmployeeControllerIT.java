package com.tvh.bootcamp.api.web;

import java.util.List;

import com.tvh.bootcamp.application.EmployeeService;
import com.tvh.bootcamp.domain.Employee;
import com.tvh.bootcamp.domain.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerIT {

    private final String allEmployeesAsJson = "[{\"name\":\"developer1\",\"role\":\"DEVELOPER\",\"workplace\":\"AIR\"},{\"name\":\"developer2\",\"role\":\"DEVELOPER\",\"workplace\":\"AIR\"},{\"name\":\"tester\",\"role\":\"TESTER\",\"workplace\":\"AIR\"},{\"name\":\"systemEnabler\",\"role\":\"SYSTEM_ENABLER\",\"workplace\":\"AIR\"}]";
    private final String developersAsJson = "[{\"name\":\"developer1\",\"role\":\"DEVELOPER\",\"workplace\":\"AIR\"},{\"name\":\"developer2\",\"role\":\"DEVELOPER\",\"workplace\":\"AIR\"}]";

    final Employee dev1 = createEmployee("developer1", Role.DEVELOPER);
    final Employee dev2 = createEmployee("developer2", Role.DEVELOPER);

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService service;

    @Test
    void getEmployees_all() throws Exception {
        final Employee tst1 = createEmployee("tester", Role.TESTER);
        final Employee se1 = createEmployee("systemEnabler", Role.SYSTEM_ENABLER);
        when(service.getAllEmployees()).thenReturn(List.of(dev1, dev2, tst1, se1));

        MvcResult mvcResult = mockMvc.perform(get("/employees")).andReturn();

        assertEquals(allEmployeesAsJson, mvcResult.getResponse().getContentAsString());
    }

    @Test
    void getEmployees_byRole() throws Exception {
        when(service.getEmployeesWithRole(Role.DEVELOPER)).thenReturn(List.of(dev1, dev2));

        MvcResult mvcResult = mockMvc.perform(get("/employees?role=DEVELOPER")).andReturn();

        assertEquals(developersAsJson, mvcResult.getResponse().getContentAsString());
    }

    private Employee createEmployee(final String name, final Role role) {
        return new Employee(name, role, "AIR");
    }
}
