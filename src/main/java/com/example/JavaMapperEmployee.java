package com.example;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
7. Convert List to Map with Conflict Resolution
Problem Statement: Given a list of Employee objects with fields:

id
name
salary
Convert it into a Map<Long, Employee> where:

Key = employee id
Value = employee object
Constraints:

If duplicate IDs exist, keep the employee with the higher salary
Do not throw exception for duplicate keys

 */
public class JavaMapperEmployee {
    public static void main(String[] args) {
        List <Employee> employeeList = Arrays.asList(
                new Employee(1L,"saurabh",10000.0),
                new Employee(2L,"jagdish",1000.0),
                new Employee(3L,"rahul",3000.0),
                new Employee(1L,"vijay",4000.0),
                new Employee(5L,"ravi",5000.0)
        );

        Map<Long,Employee> result  = employeeList.stream().collect(
          Collectors.toMap(Employee::getId,emp->emp, (e1,e2)->e1.getSalary()>e2.getSalary()?e1:e2)
        );
        System.out.println(result);
    }
}
class Employee{
    Long id;
    String name;
    Double salary;

    public Employee(Long id, String name, Double salary ) {
        this.salary = salary;
        this.name = name;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
