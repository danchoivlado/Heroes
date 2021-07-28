package com.example.heroes.services.services.implementations;

import com.example.heroes.data.models.User;
import com.example.heroes.data.repositories.UserRepository;
import com.example.heroes.services.models.users.LoggedUserServiceModel;
import com.example.heroes.services.models.users.LoginServiceModel;
import com.example.heroes.services.models.users.RegisterSreviceModel;
import com.example.heroes.services.services.UserService;
import com.example.heroes.services.services.validation.PasswordHasherService;
import com.example.heroes.services.services.validation.implementations.UserValidationServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserValidationServiceImpl validationService;
    private UserRepository repository;
    private ModelMapper modelMapper;
    private PasswordHasherService passwordHasherService;

    public UserServiceImpl(UserValidationServiceImpl validationService,
                           UserRepository repository, ModelMapper modelMapper, PasswordHasherService passwordHasherService){

        this.validationService = validationService;
        this.repository = repository;
        this.modelMapper = modelMapper;
        this.passwordHasherService = passwordHasherService;
    }

    @Override
    public void Register(RegisterSreviceModel registerSreviceModel) throws Exception {
        if (!validationService.IsRegisterParametersValid(registerSreviceModel)){
            throw new Exception();
        }

        User user = modelMapper.map(registerSreviceModel, User.class);
        String encrypetedPassword = this.passwordHasherService.hash(user.getPassword());
        user.setPassword(encrypetedPassword);
        this.repository.save(user);
    }

    @Override
    public LoggedUserServiceModel Login(LoginServiceModel serviceModel) {
        String encryptedPassword = this.passwordHasherService.hash(serviceModel.getPassword());
        if (!this.repository.existsUserByUsernameAndPassword(serviceModel.getUsername(),encryptedPassword)){
            return null;
        }
        User user = this.repository.findUserByUsernameAndPassword(serviceModel.getUsername(),encryptedPassword);
        String heroName = user.getHero() == null ? null : user.getHero().getUsername();

        return new LoggedUserServiceModel(user.getUsername(), heroName);
    }
}
