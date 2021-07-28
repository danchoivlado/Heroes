package com.example.heroes.services.services.validation;

import com.example.heroes.services.models.users.RegisterSreviceModel;

public interface UserValidationService {
    boolean IsRegisterParametersValid(RegisterSreviceModel registerSreviceModel);
}
