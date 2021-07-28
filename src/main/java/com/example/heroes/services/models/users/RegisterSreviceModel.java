package com.example.heroes.services.models.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegisterSreviceModel {
    private String username;
    private String email;
    private String password;
    private String confirmPassword;
}
