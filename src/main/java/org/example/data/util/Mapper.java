package org.example.data.util;

import org.example.data.model.User;
import org.example.dto.request.CreateRecipeRequest;
import org.example.dto.request.CreateUserLoginRequest;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public static CreateUserLoginRequest map(CreateRecipeRequest recipyRequest , User user){
        CreateUserLoginRequest loginRequest = new CreateUserLoginRequest();
        loginRequest.setUserName(user.getUsername());
        return loginRequest;
    }
}
