package com.example.heroes.services.services.implementations;

import com.example.heroes.services.services.validation.PasswordHasherService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

@Service
public class PasswordHasherServiceImpl implements PasswordHasherService {
    @Override
    public String hash(String password) {
        return DigestUtils.sha256Hex(password);
    }
}
