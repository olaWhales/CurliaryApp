package org.example.services;

import org.example.data.model.Recipe;
import org.example.dto.request.CreateRecipeRequest;
import org.example.dto.response.CreateRecipeResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecipeService {
    List<Recipe> getAllRecipes();
    List<Recipe> getRecipesByFoodName(String foodName);
    Recipe saveRecipe(Recipe recipe);
    void saveRecipes(List<Recipe> recipes);

    CreateRecipeResponse recipeRespond(CreateRecipeRequest createRecipeRequest);


//    List<Recipe> getRecipesByFoodName(String foodName);


//    List<Recipe> getAllRecipes();


//    Recipe saveRecipe(Recipe recipe);

//    void saveRecipes(List<Recipe> recipes);
}
