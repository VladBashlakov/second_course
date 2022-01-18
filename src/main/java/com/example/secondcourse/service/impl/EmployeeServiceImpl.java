package com.example.secondcourse.service.impl;

import com.example.secondcourse.data.Employee;
import com.example.secondcourse.exceptions.BadNameException;
import com.example.secondcourse.exceptions.EmployeeNotFoundException;
import com.example.secondcourse.service.DepartmentService;
import com.example.secondcourse.service.EmployeeService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<Integer, Employee> employees;

    private Integer id = 0;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    private Integer getId() {
        Integer result = id;
        id = id + 1;
        return result;
    }

    @Override
    public Employee removeEmployee(Integer id) {
        if (employees.containsKey(id)) {
            employees.remove(id);
            return employees.get(id);
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Employee getEmployee(Integer id) {
        if (employees.containsKey(id)) {
            return employees.get(id);
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public boolean check(String str) {
        if (StringUtils.isAlpha(str)) {
            return true;
        } else {
            throw new BadNameException();
        }
    }

    @Override
    public void addEmployee(String firstName, String lastName) {

        if (check(firstName) && check(lastName))
            employees.put(getId(), new Employee(StringUtils.capitalize(firstName), StringUtils.capitalize(lastName)));
    }


    @Override
    public HashMap<Integer, Employee> getAllEmployees() {
        return (HashMap<Integer, Employee>) employees;
    }

    @Override
    public Employee addEmployee(String firstName1, String lastName1, int department1, int salary1) {
        employees.put(getId(), new Employee(firstName1, lastName1, department1, salary1));
        return new Employee(firstName1, lastName1, department1, salary1);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        employees.put(getId(), employee);
        return employee;
    }


}




