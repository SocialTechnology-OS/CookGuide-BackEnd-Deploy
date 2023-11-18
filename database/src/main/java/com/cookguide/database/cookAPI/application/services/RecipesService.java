package com.cookguide.database.cookAPI.application.services;

import com.cookguide.database.cookAPI.domain.entities.Recipes;

import java.util.List;

public interface RecipesService {
    public Recipes createRecipes(Recipes recipes);

    Recipes updateRecipes(Recipes recipes);

    List<Recipes> getAllRecipes();

    void deleteRecipes(int id);

    boolean isRecipesExist(int id);
}
