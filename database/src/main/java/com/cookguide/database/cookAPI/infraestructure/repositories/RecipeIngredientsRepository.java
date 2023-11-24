package com.cookguide.database.cookAPI.infraestructure.repositories;

import com.cookguide.database.cookAPI.domain.entities.RecipeIngredientKey;
import com.cookguide.database.cookAPI.domain.entities.RecipeIngredients;
import com.cookguide.database.cookAPI.domain.entities.Recipes;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeIngredientsRepository extends CrudRepository<RecipeIngredients, RecipeIngredientKey> {
    List<RecipeIngredients> findByRecipe(Recipes recipe);
}
