package com.example.heroes.services.services.validation.implementations;

import com.example.heroes.data.repositories.UserRepository;
import com.example.heroes.services.models.users.RegisterSreviceModel;
import com.example.heroes.services.services.validation.UserValidationService;
import org.springframework.stereotype.Service;

@Service
public class UserValidationServiceImpl implements UserValidationService {

    private UserRepository userRepository;

    public UserValidationServiceImpl(UserRepository userRepository){

        this.userRepository = userRepository;
    }

    @Override
    public boolean IsRegisterParametersValid(RegisterSreviceModel model) {
        if(isPasswordMatch(model.getPassword(), model.getConfirmPassword())
            && isEmailValid(model.getEmail()) && isUsernameFree(model.getUsername())){
            return true;
        }

        return false;
    }

    private boolean isPasswordMatch(String password, String confirmPassword){
        return password.equals(confirmPassword);
    }

    private boolean isEmailValid(String email){
        return  email.contains("@");
    }

    private boolean isUsernameFree(String username){
        return !this.userRepository.existsUserByUsername(username);
    }
}
