package ru.gb.Example002.controller;


import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @GetMapping("/hello")
    public String hello() {
        return "hello user";
    }

    @GetMapping("/buy")
    public String buy() {
        return "buy user";
    }
}
