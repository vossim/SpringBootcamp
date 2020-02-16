package com.tvh.bootcamp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TvhEmployeeRepositoryTest {
    @Test
    void getAllEmployees() {
        final TvhEmployeeRepository repository = new TvhEmployeeRepository();
        assertEquals(4, repository.getEmployees().size());
    }
}
