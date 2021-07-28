package com.example.heroes.services.services;

import com.example.heroes.data.models.User;
import com.example.heroes.services.models.users.LoggedUserServiceModel;
import com.example.heroes.services.models.users.LoginServiceModel;
import com.example.heroes.services.models.users.RegisterSreviceModel;

public interface UserService {
    void Register(RegisterSreviceModel registerSreviceModel) throws Exception;
    LoggedUserServiceModel Login(LoginServiceModel loginServiceModel);
}
