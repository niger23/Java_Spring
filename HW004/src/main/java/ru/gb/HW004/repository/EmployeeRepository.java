package ru.gb.HW004.repository;

import org.springframework.stereotype.Repository;
import ru.gb.HW004.model.Employee;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {
    List<Employee> employees = new ArrayList<>();


    public void addProduct(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> getProducts() {
        return employees;
    }

}
