package com.example.heroes.data.repositories;

import com.example.heroes.data.models.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends JpaRepository<Hero,Integer> {
    Hero findHeroByUsername(String username);
    boolean existsHeroByUsername(String username);
}
