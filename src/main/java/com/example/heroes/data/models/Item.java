package com.example.heroes.data.models;

import com.example.heroes.data.base.BaseEntity;
import com.example.heroes.data.models.enums.Slot;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Base64;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "items")
public class Item extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Slot slot;

    @Column(nullable = false)
    private Integer stamina;

    @Column(nullable = false)
    private Integer strength;

    @Column(nullable = false)
    private Integer attack;

    @Column(nullable = false)
    private Integer defence;

    @ManyToMany(mappedBy = "inventory")
    private List<Hero>  heroes;
}
