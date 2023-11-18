package com.cookguide.database.cookAPI.application.services.impl;

import com.cookguide.database.cookAPI.application.services.RecipesService;
import com.cookguide.database.cookAPI.domain.entities.Recipes;
import com.cookguide.database.cookAPI.infraestructure.repositories.RecipesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipesServiceImpl implements RecipesService {
    @Autowired
    private RecipesRepository recipesRepository;

    @Override
    public Recipes createRecipes(Recipes recipes){
        return recipesRepository.save(recipes);
    }

    @Override
    public Recipes updateRecipes(Recipes recipes){
        return recipesRepository.save(recipes);
    }

    @Override
    public List<Recipes> getAllRecipes(){
        return (List<Recipes>) recipesRepository.findAll();
    }

    @Override
    public void deleteRecipes(int id){
        recipesRepository.deleteById(id);
    }

    @Override
    public boolean isRecipesExist(int id){
        return recipesRepository.existsById(id);
    }

}
