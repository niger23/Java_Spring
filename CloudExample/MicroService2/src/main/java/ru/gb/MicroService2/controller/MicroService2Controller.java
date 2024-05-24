package ru.gb.MicroService2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service2")
public class MicroService2Controller {
    @GetMapping("/hello")
    public String hello() {
        return "Hello from MicroService2";
    }
}
