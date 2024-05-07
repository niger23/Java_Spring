package ru.gb.Seminar0042.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@org.springframework.stereotype.Controller
public class Controller {
    private Random rnd = new Random();
@GetMapping("/random")
    public String getRandom(Model model) {
    int num = rnd.nextInt(100);
    model.addAttribute("number", num);
        return "random";
    }
    @GetMapping("/random/{min}/{max}")
    public String getRandomByMax(Model model,@PathVariable int min, @PathVariable int max) {
        int num = rnd.nextInt(min, max);
        model.addAttribute("number", num);
        model.addAttribute("min", min);
        model.addAttribute("max", max);
        return "randomMinMax";
    }
    @GetMapping("/random/*")
    public String getRandomByParamMinMax(Model model, @RequestParam int min, @RequestParam int max) {
        int num = rnd.nextInt(min, max);
        model.addAttribute("number", num);
        model.addAttribute("min", min);
        model.addAttribute("max", max);
        return "randomMinMax";
    }
}
