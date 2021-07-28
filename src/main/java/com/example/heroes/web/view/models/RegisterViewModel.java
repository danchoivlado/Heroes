package com.example.heroes.web.view.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegisterViewModel {
    private String username;
    private String email;
    private String password;
    private String confirmPassword;
}
