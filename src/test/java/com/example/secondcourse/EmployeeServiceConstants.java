package com.example.secondcourse;

import com.example.secondcourse.data.Employee;

import java.util.*;

public class EmployeeServiceConstants {

    public static int MIN_SALARY = 100300;
    public static int MAX_SALARY = 100500;

    public static int WRONG_ID = -1;
    public static int CORRECT_ID0 = 0;

    public static int CORRECT_DEPARTMENT = 1;
    public static int WRONG_DEPARTMENT = -1;


    public static String FIRST_NAME1 = "Ivan";
    public static String LAST_NAME1 = "Ivanov";
    public static int DEPARTMENT1 = 1;
    public static int SALARY1 = 100500;

    public static String FIRST_NAME2 = "Petr";
    public static String LAST_NAME2 = "Petrov";
    public static int DEPARTMENT2 = 2;
    public static int SALARY2 = 100300;

    public static String FIRST_NAME3 = "Vasiliy";
    public static String LAST_NAME3 = "Vasiliev";
    public static int DEPARTMENT3 = 2;
    public static int SALARY3 = 100500;

    public static final Collection<Employee> EMPLOYEES = List.of(
            new Employee("Ivan", "Ivanov", 1, 100500),
            new Employee("Petr", "Petrov", 2, 100300),
            new Employee("Vasiliy", "Vasiliev", 2, 100500)
    );
}
