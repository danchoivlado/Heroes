package com.example.heroes.services.services;

import com.example.heroes.services.models.heroes.HeroDetailsServiceModel;

public interface HeroService {
    HeroDetailsServiceModel getDetailsAboutHero(String name);
}
