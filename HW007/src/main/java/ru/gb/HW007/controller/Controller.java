package ru.gb.HW007.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gb.HW007.service.UserService;

@org.springframework.stereotype.Controller
@RequiredArgsConstructor
public class Controller {
    private final UserService userService;

    @GetMapping("/index")
    public String home(Model model) {
        model.addAttribute("text", userService.getAllText());
        return "index";
    }

    @GetMapping("/public-data")
    public String user(Model model) {
        model.addAttribute("text", userService.getUserText());
        return "public-data";
    }

    @GetMapping("/private-data")
    public String admin(Model model) {
        model.addAttribute("text", userService.getAdminText());
        return "private-data";
    }
}
