package org.example.controller;

import org.example.data.model.Recipe;
import org.example.dto.request.CreateUserLoginRequest;
import org.example.dto.request.CreateUserSignUpRequest;
import org.example.services.RecipeService;
import org.example.services.UserLoginService;
import org.example.services.UserSignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@Controller
@RequestMapping("/api/recipes")
public class UserController {
    @Autowired
    private UserSignUpService userSignUpService;
    @CrossOrigin(origins = "*")
    @PostMapping("/User-Sign-Up")
    public ResponseEntity<?> UserSignUp(@RequestBody CreateUserSignUpRequest createUserSignUpRequest){
        try{
            return new ResponseEntity<>(userSignUpService.createUser(createUserSignUpRequest),CREATED);
        }catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(),BAD_REQUEST);
        }
    }

    @Autowired
    private UserLoginService userLoginService ;
    @CrossOrigin(origins = "*")
    @PostMapping("/User-Login")
    public ResponseEntity<?> UserLogin(@RequestBody CreateUserLoginRequest createUserLoginRequest){
        try{
            return new ResponseEntity<>(userLoginService.createLogin(createUserLoginRequest),CREATED);
        }catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(),BAD_REQUEST);
        }
    }

    @Autowired
    private RecipeService recipeService;
    @CrossOrigin(origins = "*")
    @GetMapping("/recipes")
    public List<Recipe> getRecipes() {
        return recipeService.getAllRecipes();
    }

    @CrossOrigin(origins = "*")
        @GetMapping("/recipes/{foodName}")
        public List<Recipe> getRecipes(@PathVariable String foodName) {
            return recipeService.getRecipesByFoodName(foodName);
        }

    }


