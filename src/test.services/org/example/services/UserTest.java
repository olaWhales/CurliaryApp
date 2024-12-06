package org.example.services;

//import org.example.api.Recipes;
import org.example.data.model.Recipe;
import org.example.data.model.User;
import org.example.data.model.UserSignUp;
import org.example.data.repository.LoginRepository;
import org.example.data.repository.RecipeRepository;
import org.example.data.repository.SignUpRepository;
import org.example.dto.request.CreateRecipeRequest;
import org.example.dto.request.CreateUserLoginRequest;
import org.example.dto.request.CreateUserSignUpRequest;
import org.example.dto.response.CreateRecipeResponse;
import org.example.dto.response.CreateUserLoginRespond;
import org.example.dto.response.CreateUserSignUpRespond;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserTest {
    @Autowired
    private UserLoginService userLoginService;
    @Autowired
    private UserSignUpService userSignUpService;
    @Autowired
    private SignUpRepository signUpRepository;
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private RecipeService recipeService;
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private Recipe recipe;

    @BeforeEach
    void clear() {
        signUpRepository.deleteAll();
        loginRepository.deleteAll();
    }

    @Test
    public void testThatUserCanRegister() {
        CreateUserSignUpRespond respond = userSignUpService.createUser(new CreateUserSignUpRequest());
        CreateUserSignUpRequest request = new CreateUserSignUpRequest();
        UserSignUp signUp = new UserSignUp();
        signUp.setFullName(request.getFullName());
        signUp.setUsername(request.getUserName());
        signUp.setEmail(request.getEmail());
        signUp.setPassword(request.getPassword());
        signUpRepository.save(signUp);
        respond.setMessage("Registered successful");
        assertEquals(respond.getMessage(), "Registered successful");
    }

    @Test
    public void TestThatUserCanLogin() {
        CreateUserLoginRespond respond = userLoginService.createLogin(new CreateUserLoginRequest());
        CreateUserSignUpRequest request = new CreateUserSignUpRequest();
        User login = new User();
        login.setUsername(request.getUserName());
        login.setPassword(request.getPassword());
        loginRepository.save(login);
        respond.setMessage(respond.getMessage());
        assertEquals(respond.getMessage(), "You're welcome, Login successful");
    }

    @Test
    public void testThatExistingUserCannotRegisterTwice() {
        CreateUserSignUpRequest request = new CreateUserSignUpRequest();
        request.setFullName("Taoreed Olawale");
        request.setUserName("@whales");
        request.setEmail("ajaditaoreed@gmail.com");
        request.setPassword("11111");
        CreateUserSignUpRespond respond = userSignUpService.createUser(request);
        assertNotNull(respond);
        request.setFullName("Taoreed Olawale");
        request.setUserName("@whales");
        request.setEmail("ajaditaoreed@gmail.com");
        request.setPassword("11111");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            userSignUpService.createUser(request);
        });
        assertEquals(signUpRepository.count(), 1);
        assertEquals(exception.getMessage(), "User already exist");
    }

    @Test
    public void testThatUserCanGetRecipe() {
        CreateRecipeResponse recipesRespond = recipeService.recipeRespond(new CreateRecipeRequest());
        CreateRecipeRequest request = new CreateRecipeRequest();
        Recipe recipe = new Recipe();
        recipe.setFoodName("White rice");
        recipeRepository.save(recipe);
        List<Recipe> recipes = recipeService.getRecipesByFoodName("White rice");
        assertEquals(recipes.size(), 1);
        Recipe fetch = new Recipe();
        assertEquals(fetch.getGetAllRecipes(), "");

    }
}





