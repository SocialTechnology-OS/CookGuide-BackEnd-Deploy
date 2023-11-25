package com.cookguide.database.cookAPI.application.services;

import com.cookguide.database.cookAPI.application.dto.request.RecipesRequestDTO;
import com.cookguide.database.cookAPI.application.dto.response.AuthorDetailDTO;
import com.cookguide.database.cookAPI.application.dto.response.RecipeIngredientDetailDTO;
import com.cookguide.database.cookAPI.application.dto.response.RecipesResponseDTO;
import com.cookguide.database.shared.model.dto.response.ApiResponse;

import java.util.List;

public interface RecipesService {

    ApiResponse<List<RecipesResponseDTO>> getAllRecipes();

    ApiResponse<RecipesResponseDTO> createRecipes(RecipesRequestDTO recipesRequestDTO);

    ApiResponse<RecipesResponseDTO> updateRecipes(int id, RecipesRequestDTO recipesRequestDTO);

    ApiResponse<Void> deleteRecipes(int id);

    ApiResponse<RecipesResponseDTO> getRecipeById(int id);

    List<RecipeIngredientDetailDTO> getRecipeIngredients(int recipeId);



    List<AuthorDetailDTO> getAuthorDetailsByRecipeId(int recipeId);
}
