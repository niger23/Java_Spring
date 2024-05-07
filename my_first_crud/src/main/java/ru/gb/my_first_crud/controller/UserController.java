package ru.gb.my_first_crud.controller;


import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gb.my_first_crud.model.User;
import ru.gb.my_first_crud.service.UserService;

import java.util.List;

@Controller
@Log
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String findAll(Model model){
        List<User> users = userService.findAll();
        log.info("used find all");
        model.addAttribute("users", users);
        return "user-list";
        //return "home.html";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user){
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user){
        log.info("create user" + user);
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        log.info("delete user " + id);
        userService.deleteById(id);
        return "redirect:/users";
    }
    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") int id, Model model){
        User user = userService.findById(id);
        log.info("update user " + id);
        model.addAttribute("user", user);
        return "user-update";
    }
    @PostMapping("/user-update/*")
    public String updateUser(User user){
        userService.updateUser(user);
        return "redirect:/users";
    }
}