package com.example.example4sem6_rikky_and_morty_rest.controller;

import com.example.example4sem6_rikky_and_morty_rest.service.ServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ControllerAPI {
    @Autowired
    private ServiceApi serviceApi;

    @GetMapping("/characters")
    public String listUsers(Model model) {
        model.addAttribute("results", serviceApi.getAllCharacters().getResults());
        return "personList";
    }

    @GetMapping("/characters/{id}")
    public String getUser(@PathVariable Long id, Model model) {
        model.addAttribute("result", serviceApi.getSingleCharacter(id));
        return "person";
    }
}
