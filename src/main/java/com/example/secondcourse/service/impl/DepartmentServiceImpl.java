package com.example.secondcourse.service.impl;

import com.example.secondcourse.data.Employee;
import com.example.secondcourse.exceptions.EmployeeNotFoundException;
import com.example.secondcourse.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    EmployeeServiceImpl employeeService;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee getEmployeeWithMinSalary(int department) {
        return employeeService.getEmployees().values().stream()
                .filter(e -> e.isDepartment(department))
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee getEmployeeWithMaxSalary(int department) {
        return employeeService.getEmployees().values().stream()
                .filter(e -> e.isDepartment(department))
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Collection<Employee> getEmployeesFor(int department) {
        return employeeService.getEmployees().values().stream()
                .filter(e -> e.isDepartment(department))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployeesByDepartment() {
        return employeeService.getEmployees().values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
