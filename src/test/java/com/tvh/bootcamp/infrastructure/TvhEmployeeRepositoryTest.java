package com.tvh.bootcamp.infrastructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TvhEmployeeRepositoryTest {
    @Test
    void getAllEmployees() {
        final TvhEmployeeRepository repository = new TvhEmployeeRepository();
        assertEquals(4, repository.getEmployees().size());
    }
}
