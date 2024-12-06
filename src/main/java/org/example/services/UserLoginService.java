package org.example.services;

import org.example.dto.request.CreateUserLoginRequest;
import org.example.dto.response.CreateUserLoginRespond;

//@Service
public interface UserLoginService {
    CreateUserLoginRespond createLogin(CreateUserLoginRequest request);
}
