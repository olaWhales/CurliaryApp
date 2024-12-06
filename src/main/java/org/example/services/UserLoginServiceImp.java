package org.example.services;

import org.example.data.model.User;
import org.example.data.repository.LoginRepository;
import org.example.dto.request.CreateUserLoginRequest;
import org.example.dto.response.CreateUserLoginRespond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImp implements UserLoginService{
    @Autowired
    private LoginRepository loginRepository ;

    @Override
    public CreateUserLoginRespond createLogin(CreateUserLoginRequest request){
        User login = new User();
        login.setUsername(request.getUserName());
        login.setPassword(request.getPassword());
        loginRepository.save(login);
        CreateUserLoginRespond respond = new CreateUserLoginRespond();
        respond.setMessage("You're welcome, Login successful");
        return respond;
    }
}
