package com.example.secondcourse.service;

import com.example.secondcourse.data.Employee;


import java.util.HashMap;

public interface EmployeeService {

    void removeEmployee(Integer id);

    Employee getEmployee(Integer id);

    void addEmployee(String firstName, String lastName);

    HashMap<Integer, Employee> printAllEmployees();

    boolean check(String str);


}
