package com.example.secondcourse;


import com.example.secondcourse.service.impl.DepartmentServiceImpl;
import com.example.secondcourse.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static com.example.secondcourse.EmployeeServiceConstants.*;
import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    private DepartmentServiceImpl out;

    @Mock
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    public void setUp() {
        out = new DepartmentServiceImpl(employeeService);

        when(employeeService.getAllEmployees().values())
                .thenReturn(EMPLOYEES);
    }

    @Test
    public void getAllEmployees() {


        assertEquals(EMPLOYEES, out.getAllEmployeesByDepartment());
        assertEquals(emptyList(), out.getEmployeesFor(WRONG_DEPARTMENT));
//        assertIterableEquals(EMPLOYEES, out.getEmployeesFor(CORRECT_DEPARTMENT));

    }

    @Test
    public void testGetEmployeeWithMinSalaryMethod() {
        assertEquals(MIN_SALARY, out.getEmployeeWithMinSalary(CORRECT_DEPARTMENT).getSalary());
    }

    @Test
    public void testGetEmployeeWithMaxSalaryMethod() {
        assertEquals(MAX_SALARY, out.getEmployeeWithMaxSalary(CORRECT_DEPARTMENT).getSalary());
    }

    @Test
    public void returnEmptyListWhenEmployeesDontExist() {
        when(employeeService.getAllEmployees().values())
                .thenReturn(emptyList());

        assertTrue(out.getEmployeesFor(CORRECT_DEPARTMENT).isEmpty());
    }


}
