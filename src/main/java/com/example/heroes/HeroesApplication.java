package com.example.heroes;

import com.example.heroes.data.models.Item;
import com.example.heroes.data.models.User;
import com.example.heroes.data.models.enums.Gender;
import com.example.heroes.data.models.Hero;
import com.example.heroes.data.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HeroesApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(HeroesApplication.class, args);
//        HeroRepository heroRepository = ctx.getBean(HeroRepository.class);
//        UserRepository userRepository = ctx.getBean(UserRepository.class);
//        ItemRepository itemRepository = ctx.getBean(ItemRepository.class);
//
//        Hero hero = heroRepository.findAll().stream().filter(f -> f.getId() == 1).findFirst().orElse(null);
//        User user = userRepository.findAll().stream().filter(u -> u.getId() == 1).findFirst().orElse(null);
//
//
//        Gender gender = hero.getGender();
    }


}
