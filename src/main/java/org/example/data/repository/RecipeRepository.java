package org.example.data.repository;

import org.example.data.model.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends MongoRepository <Recipe, String>{
//    List<Recipe>  findByfoodName(String name);

    List<Recipe> findByFoodName(String foodName);
}
