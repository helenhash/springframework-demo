package com.helen.demo.entity;

import com.helen.demo.EmployeeWork;

public class Employee {
    private String name;
    private EmployeeWork employeeWork;

    public Employee(String name, EmployeeWork employeeWork) {
        this.name = name;
        this.employeeWork = employeeWork;
    }
    // Method
    public void working()
    {
        System.out.println("My Name is: " + name);
        employeeWork.work();
    }
}
