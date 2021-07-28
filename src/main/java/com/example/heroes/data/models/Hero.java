package com.example.heroes.data.models;

import com.example.heroes.data.base.BaseEntity;
import com.example.heroes.data.models.enums.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "heroes")
@Getter
@Setter
@NoArgsConstructor
public class Hero extends BaseEntity {

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private Integer level;

    @Column(nullable = false)
    private Integer stamina;

    @Column(nullable = false)
    private Integer strength;

    @Column(nullable = false)
    private Integer attack;

    @Column(nullable = false)
    private Integer defence;

    @OneToOne(mappedBy = "hero")
    private User user;

    @ManyToMany
    @JoinTable(name = "hero_items",joinColumns = @JoinColumn(name = "heroes_id"),
    inverseJoinColumns = @JoinColumn(name = "items_id"))
    private List<Item> inventory;

}
