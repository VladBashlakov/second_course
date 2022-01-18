package com.example.secondcourse;

import com.example.secondcourse.data.Employee;
import com.example.secondcourse.exceptions.BadNameException;
import com.example.secondcourse.exceptions.EmployeeNotFoundException;
import com.example.secondcourse.service.EmployeeService;
import com.example.secondcourse.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;


import static com.example.secondcourse.EmployeeServiceConstants.*;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {

    private EmployeeService out = new EmployeeServiceImpl();

    Employee employee1;
    Employee employee2;
    Employee employee3;

    @BeforeEach
    public void setUp() {

        employee1 = new Employee(FIRST_NAME1, LAST_NAME1, DEPARTMENT1, SALARY1);
        employee2 = new Employee(FIRST_NAME2, LAST_NAME2, DEPARTMENT2, SALARY2);
        employee3 = new Employee(FIRST_NAME3, LAST_NAME3, DEPARTMENT3, SALARY3);

        out = new EmployeeServiceImpl();

        out.addEmployee(employee1);
        out.addEmployee(employee2);
        out.addEmployee(employee3);

    }

    @Test
    void testAddEmployeeServiceMethod() {
        Collection<Employee> exp = new ArrayList<>(out.getAllEmployees().values());
        Collection<Employee> act = new ArrayList<>();

        act.add(employee1);
        act.add(employee2);
        act.add(employee3);

        assertTrue(act.size() == exp.size() && act.containsAll(exp) && exp.containsAll(act));
        assertEquals(employee1, out.addEmployee(employee1));

    }

    @Test
    void testGetEmployeeServiceMethod() {
        assertEquals(employee1, out.getEmployee(CORRECT_ID0));
    }

    @Test
    void testRemoveEmployeeServiceMethod() {
        assertNull(out.removeEmployee(CORRECT_ID0));
    }

    @Test
    void testExceptionIfEmployeeAlreadyExist() {
        assertThrows(BadNameException.class, () -> out.check(FIRST_NAME1 + 1));
    }

    @Test
    void testExceptionIfEmployeeNotFound() {
        assertThrows(EmployeeNotFoundException.class, () -> out.getEmployee(WRONG_ID));
        assertThrows(EmployeeNotFoundException.class, () -> out.removeEmployee(WRONG_ID));
    }
}


