package com.example.heroes.services.models.heroes;

import com.example.heroes.data.models.enums.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HeroDetailsServiceModel {
    private String username;
    private Gender gender;
    private Integer level;
    private Integer stamina;
    private Integer strength;
    private Integer attack;
    private Integer defence;

    private HeroItemServiceModel weapon;
    private HeroItemServiceModel helmet;
    private HeroItemServiceModel pauldron;
    private HeroItemServiceModel pads;
    private HeroItemServiceModel gauntlets;
}
