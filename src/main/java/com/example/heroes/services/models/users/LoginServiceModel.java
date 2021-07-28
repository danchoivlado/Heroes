package com.example.heroes.services.models.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginServiceModel {
    private String username;
    private String password;
}
