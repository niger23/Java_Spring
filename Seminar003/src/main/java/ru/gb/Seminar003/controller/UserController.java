package ru.gb.Seminar003.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.Seminar003.domain.User;
import ru.gb.Seminar003.service.RegistrationService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getRepository().getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user)
    {
        service.getDataProcessingService().getRepository().saveUser(user);
        return "User added from body!";
    }

    @PostMapping("/body/{name}/{age}/{email}")
    public String userAddFromPath(@PathVariable String name, @PathVariable int age, @PathVariable String email)
    {
        service.processRegistration(name, age, email);

        return "User added from body!";
    }

    @PostMapping("/param/*")
    public String userAddFromParam(@RequestParam("name") String name, @RequestParam("age") int age, @RequestParam("email") String email)
    {
        service.processRegistration(name, age, email);

        return "User added from body!";
    }

}
