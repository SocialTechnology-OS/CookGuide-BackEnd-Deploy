package com.cookguide.database.cookAPI.application.services;

import com.cookguide.database.cookAPI.application.dto.request.IngredientsRequestDTO;
import com.cookguide.database.cookAPI.application.dto.request.RecipesRequestDTO;
import com.cookguide.database.cookAPI.application.dto.response.IngredientsResponseDTO;
import com.cookguide.database.shared.model.dto.response.ApiResponse;

import java.util.List;

public interface IngredientsService {
    ApiResponse<List<IngredientsResponseDTO>> getAllIngredients();

    ApiResponse<IngredientsResponseDTO> createIngredient(IngredientsRequestDTO ingredientsRequestDTO);

    ApiResponse<IngredientsResponseDTO> updateIngredient(int id, IngredientsRequestDTO ingredientsRequestDTO);

    ApiResponse<Void> deleteIngredient(int id);
}
