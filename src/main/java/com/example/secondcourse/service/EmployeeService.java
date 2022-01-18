package com.example.secondcourse.service;

import com.example.secondcourse.data.Employee;


import java.util.Collection;
import java.util.HashMap;

public interface EmployeeService {

    Employee removeEmployee(Integer id);

    Employee getEmployee(Integer id);


    void addEmployee(String firstName, String lastName);

    Employee addEmployee(Employee employee);

    HashMap<Integer, Employee> getAllEmployees();

    boolean check(String str);

    Employee addEmployee(String firstName1, String lastName1, int department1, int salary1);
}
