package ru.gb.HW004.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gb.HW004.model.Employee;
import ru.gb.HW004.repository.EmployeeRepository;

@Controller
@AllArgsConstructor
public class EmployeeController {
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public String getProduct(Model model) {
        model.addAttribute("employees", employeeRepository.getProducts());
        return "employees";
    }
    @PostMapping("/employees")
    public String addProduct(Model model, Employee employee) {
        employeeRepository.addProduct(employee);
        model.addAttribute("employees", employeeRepository.getProducts());
        return "employees";
    }
}
