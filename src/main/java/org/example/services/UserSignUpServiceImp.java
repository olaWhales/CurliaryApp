package org.example.services;

import org.example.data.model.UserSignUp;
import org.example.data.repository.SignUpRepository;
import org.example.dto.request.CreateUserSignUpRequest;
import org.example.dto.response.CreateUserSignUpRespond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSignUpServiceImp implements UserSignUpService{
    @Autowired
    SignUpRepository signUpRepository;

    @Override
    public CreateUserSignUpRespond createUser(CreateUserSignUpRequest request) {
        UserSignUp signup = signUpRepository.findByUsername((request.getUserName()));
        if(signup != null)throw new IllegalArgumentException("User already exist");

        UserSignUp signUp = new UserSignUp();
        signUp.setFullName(request.getFullName());
        signUp.setUsername(request.getUserName());
        signUp.setEmail(request.getEmail());
        signUp.setPassword(request.getPassword());
        signUpRepository.save(signUp);
        CreateUserSignUpRespond respond = new CreateUserSignUpRespond();
        respond.setMessage("Registered successful");
        return respond;
    }

}
