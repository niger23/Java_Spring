package ru.gb.Seminat0071.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping
    public String startPage() {
        return "index.html";
    }
}
