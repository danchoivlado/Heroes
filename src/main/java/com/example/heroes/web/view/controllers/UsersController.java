package com.example.heroes.web.view.controllers;

import com.example.heroes.data.models.User;
import com.example.heroes.services.models.users.LoggedUserServiceModel;
import com.example.heroes.services.models.users.LoginServiceModel;
import com.example.heroes.services.models.users.RegisterSreviceModel;
import com.example.heroes.services.services.implementations.UserServiceImpl;
import com.example.heroes.web.view.models.LoginViewModel;
import com.example.heroes.web.view.models.RegisterViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class UsersController {

    private ModelMapper modelMapper;
    private UserServiceImpl userService;

    public UsersController(ModelMapper modelMapper, UserServiceImpl userService){

        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(){

        return "users/login";
    }

    @PostMapping("/login")
    public String loginConfirm(@ModelAttribute LoginViewModel loginViewModel, HttpSession session){
        LoginServiceModel loginServiceModel = modelMapper.map(loginViewModel, LoginServiceModel.class);
        LoggedUserServiceModel userCredential = this.userService.Login(loginServiceModel);
        if (userCredential == null){
            return "/users/login";
        }

        session.setAttribute("user",userCredential);
        return "redirect:/home";
    }

    @GetMapping("/register")
    public String register(@ModelAttribute RegisterViewModel model){

        return "users/register";
    }

    @PostMapping("/register")
    public String registerConfirm(@ModelAttribute RegisterViewModel model){
        RegisterSreviceModel registerSreviceModel = modelMapper.map(model, RegisterSreviceModel.class);
        try {
            this.userService.Register(registerSreviceModel);
        }catch (Exception ex){
            return "/users/register";
        }
        return "redirect:/home";
    }

    @GetMapping("/profile")
    public String profile(){

        return "users/profile";
    }
}
