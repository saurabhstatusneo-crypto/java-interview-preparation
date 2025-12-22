package org.example;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/***
 * 1. Top-K Elements Per Group
 * Problem Statement:
 * Given a list of Employee objects (id, name, department, salary), return a map where the key is the department and the value is the top 3 highest-paid employees in that department, sorted by salary descending.
 * Constraints:
 * Preserve employee uniqueness
 * If a department has fewer than 3 employees, return all
 */
public class TopKEmpPerGroup {
static List<Employee> employeeList = Arrays.asList(
        new Employee(1L,"saurabh","java",5000l),
        new Employee(2L,"jagdish","elk",1000l),
        new Employee(3L,"abhinav","java",12000l),
        new Employee(4L,"dinesh","elk",3000l),
         new Employee(5L,"ravi","elk",4000l)
);

    public static void main(String[] args) {
        Map<String, List<Employee>> map = employeeList.stream().collect(
                Collectors.groupingBy(Employee::getDepartment, ()-> new TreeMap<>(), Collectors.collectingAndThen(Collectors.toList(),
                list -> list.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(1).collect(Collectors.toList()))));

        System.out.println(map);
    }
}

class Employee{
    Long id;
    String name;
    String department;
    Long salary;

    public Employee(Long id, String name, String department, Long salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
