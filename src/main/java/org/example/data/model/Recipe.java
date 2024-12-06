package org.example.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "recipe")
public class Recipe {
    @Id
    private String id;
    private String foodName;
    private String ingredients;
    private String instructions;
    public List<Recipe> getAllRecipes ;
}
