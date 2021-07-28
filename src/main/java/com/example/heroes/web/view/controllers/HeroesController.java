package com.example.heroes.web.view.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/heroes")
public class HeroesController {

    @GetMapping("/create")
    public String create(){

        return "/heroes/create-hero";
    }

    @GetMapping("/details/{name}")
    public String details(@PathVariable String name){
        System.out.println(name);
        return "/heroes/hero-details";
    }
}
