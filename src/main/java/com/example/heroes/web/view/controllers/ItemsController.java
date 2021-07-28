package com.example.heroes.web.view.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/items")
public class ItemsController {

    @GetMapping("/create")
    public String create(){

        return "/items/create-item";
    }

    @GetMapping("/merchant")
    public String merchant(){

        return "/items/merchant";
    }
}
