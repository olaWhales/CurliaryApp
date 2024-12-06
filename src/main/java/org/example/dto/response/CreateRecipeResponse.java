package org.example.dto.response;

import lombok.Data;
import org.example.data.model.Recipe;

import java.util.List;

@Data
public class CreateRecipeResponse {
    List<Recipe>recipes;
}
