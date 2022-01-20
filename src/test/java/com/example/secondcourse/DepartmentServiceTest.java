package com.example.secondcourse;


import com.example.secondcourse.data.Employee;
import com.example.secondcourse.service.impl.DepartmentServiceImpl;
import com.example.secondcourse.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.secondcourse.EmployeeServiceConstants.*;
import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;
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

        EMPLOYEE_HASH_MAP.put(0, new Employee(FIRST_NAME0, LAST_NAME0, DEPARTMENT0, SALARY0));
        EMPLOYEE_HASH_MAP.put(1, new Employee(FIRST_NAME1, LAST_NAME1, DEPARTMENT1, SALARY1));
        EMPLOYEE_HASH_MAP.put(2, new Employee(FIRST_NAME2, LAST_NAME2, DEPARTMENT2, SALARY2));
        EMPLOYEE_HASH_MAP.put(3, new Employee(FIRST_NAME3, LAST_NAME3, DEPARTMENT3, SALARY3));

        EMPLOYEE_HASH_MAP_BY_DEPARTMENT.put(0, new Employee(FIRST_NAME0, LAST_NAME0, DEPARTMENT0, SALARY0));
        EMPLOYEE_HASH_MAP_BY_DEPARTMENT.put(1, new Employee(FIRST_NAME1, LAST_NAME1, DEPARTMENT0, SALARY1));

        EMPLOYEE_LIST_BY_DEPARTMENT1.add(new Employee(FIRST_NAME0, LAST_NAME0, DEPARTMENT0, SALARY0));
        EMPLOYEE_LIST_BY_DEPARTMENT1.add(new Employee(FIRST_NAME1, LAST_NAME1, DEPARTMENT1, SALARY1));
        EMPLOYEE_LIST_BY_DEPARTMENT2.add(new Employee(FIRST_NAME2, LAST_NAME2, DEPARTMENT2, SALARY2));
        EMPLOYEE_LIST_BY_DEPARTMENT2.add(new Employee(FIRST_NAME3, LAST_NAME3, DEPARTMENT3, SALARY3));


        INTEGER_LIST_MAP.put(DEPARTMENT1, EMPLOYEE_LIST_BY_DEPARTMENT1);
        INTEGER_LIST_MAP.put(DEPARTMENT2, EMPLOYEE_LIST_BY_DEPARTMENT2);


        when(employeeService.getAllEmployees())
                .thenReturn(EMPLOYEE_HASH_MAP);

    }

    @InjectMocks
    private DepartmentServiceImpl getOut;

    @Test
    public void testGetAllEmployeesByDepartmentMethod() {
        assertEquals(INTEGER_LIST_MAP, out.getAllEmployeesByDepartment());
    }

    @Test
    public void testEmployeesForMethodWithWrongDepartment() {
        assertEquals(EMPTY_LIST, out.getEmployeesFor(WRONG_DEPARTMENT));
    }

    @Test
    public void testGetEmployeeWithMinSalaryMethod() {
        assertEquals(MIN_SALARY, out.getEmployeeWithMinSalary(CORRECT_DEPARTMENT).getSalary());
    }

    @Test
    public void testGetEmployeeWithMaxSalaryMethod() {
        assertEquals(MAX_SALARY, out.getEmployeeWithMaxSalary(CORRECT_DEPARTMENT).getSalary());
    }


}
