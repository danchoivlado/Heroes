package com.example.heroes.services.models.heroes;

import com.example.heroes.data.models.enums.Slot;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class HeroItemServiceModel {
    private String name;
    private Slot slot;
    private Integer stamina;
    private Integer strength;
    private Integer attack;
    private Integer defence;
}
