package com.techieuday.javastreams.sections.section4.terminal.ops;

import com.techieuday.javastreams.factory.EmployeeFactory;
import com.techieuday.javastreams.model.Department;
import com.techieuday.javastreams.model.Employee;

import java.util.List;
import java.util.Comparator;

import static com.techieuday.javastreams.constants.Constants.LARGE_LIMIT;
import static com.techieuday.javastreams.constants.Constants.MEDIUM_LIMIT;
import static com.techieuday.javastreams.utils.CommonUtils.between;

public class CountMinAndMaxDemo {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeFactory.randomEmployees(100);
        // Count
        long employeeCount = employees.stream().count();
        System.out.println("Total Employees: " + employeeCount);

        // Min (Employee with Lowest Salary)
        Employee minSalaryEmp = employees.stream()
                .filter(e -> e.getDepartment() == Department.PROCUREMENT)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow();
        System.out.println("Employee with Min Salary: " + minSalaryEmp);

        // Max (Employee with Highest Salary)
        Employee maxSalaryEmp = employees.stream()
                .filter(e -> e.getDepartment() == Department.PROCUREMENT)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow();
        System.out.println("Employee with Max Salary: " + maxSalaryEmp);
    }
}

