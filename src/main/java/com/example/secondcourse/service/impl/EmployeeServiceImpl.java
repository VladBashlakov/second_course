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

    private Map<Integer, Employee> employees;

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
    public void removeEmployee(Integer id) {
        if (employees.containsKey(id)) {
            employees.remove(id);
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
    public HashMap<Integer, Employee> printAllEmployees() {
        return (HashMap<Integer, Employee>) employees;
    }

    public Map<Integer, Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Map<Integer, Employee> employees) {
        this.employees = employees;
    }


}




