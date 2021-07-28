package com.example.heroes.web.view.controllers;

import com.example.heroes.services.models.heroes.HeroDetailsServiceModel;
import com.example.heroes.services.services.HeroService;
import com.example.heroes.services.services.implementations.HeroServiceImpl;
import com.example.heroes.web.view.models.heroes.HeroesDetailsViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/heroes")
public class HeroesController {

    private ModelMapper modelMapper;
    private HeroService heroService;

    public HeroesController(ModelMapper modelMapper, HeroService heroService ) {
        this.modelMapper = modelMapper;
        this.heroService = heroService;
    }

    @GetMapping("/create")
    public String create(){

        return "/heroes/create-hero";
    }

    @GetMapping("/details/{name}")
    public ModelAndView details(@PathVariable String name, ModelAndView modelAndView){

        HeroDetailsServiceModel heroDetailsServiceModel = this.heroService.getDetailsAboutHero(name);
        if (heroDetailsServiceModel == null){
            modelAndView.setViewName("/home/index");
            return modelAndView;
        }

        HeroesDetailsViewModel model = modelMapper.map(heroDetailsServiceModel, HeroesDetailsViewModel.class);

        modelAndView.addObject("hero", model);
        modelAndView.setViewName("/heroes/hero-details");
        return  modelAndView;
    }
}
