package ru.gb.MicroService1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service1")
public class MicroService1Controller {
    @GetMapping("/hello")
    public String hello() {
        return "Hello from MicroService1";
    }
}
