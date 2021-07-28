package com.example.heroes.data.models;

import com.example.heroes.data.base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@NoArgsConstructor
@Getter
@Entity
@Table(name = "Users")
public class User extends BaseEntity {

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @OneToOne
    @JoinColumn(name  = "hero_id", referencedColumnName = "id")
    private Hero hero;

}

