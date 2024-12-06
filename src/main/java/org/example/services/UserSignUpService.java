package org.example.services;

import org.example.dto.request.CreateUserSignUpRequest;
import org.example.dto.response.CreateUserSignUpRespond;

//@Service
public interface UserSignUpService {
    CreateUserSignUpRespond createUser (CreateUserSignUpRequest request);
}
