package org.example.services;

import org.example.data.model.Recipe;
import org.example.data.model.User;
import org.example.data.repository.LoginRepository;
import org.example.data.repository.RecipeRepository;
import org.example.data.util.Mapper;
import org.example.dto.request.CreateRecipeRequest;
import org.example.dto.response.CreateRecipeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List ;

@Service
public class RecipeServiceImp implements RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private Mapper mapper;


    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }
    @Override
    public List<Recipe> getRecipesByFoodName(String foodName) {
//        CreateRecipeResponse response = new CreateRecipeResponse();
        CreateRecipeRequest request = new CreateRecipeRequest();
        getRecipesByFoodName(request.getFoodName());
        Recipe recipe = new Recipe();
        recipe.setFoodName(request.getFoodName());
        CreateRecipeResponse response = new CreateRecipeResponse();
        response.setRecipes(recipe.getAllRecipes);
//        return (List<Recipe>) response;
        return recipeRepository.findByFoodName(foodName);
    }
    @Override
    public Recipe saveRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }
    @Override
    public void saveRecipes(List<Recipe> recipes) {
    }
    @Override
    public CreateRecipeResponse recipeRespond(CreateRecipeRequest createRecipeRequest) {
        CreateRecipeRequest request = new CreateRecipeRequest();
        if (createRecipeRequest != null) {
            getRecipesByFoodName(request.getFoodName());
        }
        Recipe recipe = new Recipe();
        recipe.setFoodName(request.getFoodName());
        CreateRecipeResponse response = new CreateRecipeResponse();
        response.setRecipes(recipe.getAllRecipes);
        return response ;
    }


}
