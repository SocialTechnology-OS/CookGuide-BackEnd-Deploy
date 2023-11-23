package com.cookguide.database.cookAPI.application.services.impl;

import com.cookguide.database.cookAPI.application.dto.request.IngredientsRequestDTO;
import com.cookguide.database.cookAPI.application.dto.response.IngredientsResponseDTO;
import com.cookguide.database.cookAPI.application.dto.response.RecipesResponseDTO;
import com.cookguide.database.cookAPI.application.services.IngredientsService;
import com.cookguide.database.cookAPI.domain.entities.Ingredients;
import com.cookguide.database.cookAPI.infraestructure.repositories.IngredientRepository;
import com.cookguide.database.shared.model.dto.response.ApiResponse;
import com.cookguide.database.shared.model.enums.Estatus;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IngredientsServiceImpl implements IngredientsService {

    private final IngredientRepository ingredientRepository;
    private final ModelMapper modelMapper;

    public IngredientsServiceImpl(IngredientRepository ingredientRepository, ModelMapper modelMapper) {
        this.ingredientRepository = ingredientRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse<List<IngredientsResponseDTO>> getAllIngredients() {
        List<Ingredients> ingredientsList = (List<Ingredients>) ingredientRepository.findAll();
        List<IngredientsResponseDTO> ingredientsDTOList = ingredientsList.stream()
                .map(entity -> modelMapper.map(entity, IngredientsResponseDTO.class))
                .collect(Collectors.toList());

        return new ApiResponse<>("All ingredients fetched successfully", Estatus.SUCCESS, ingredientsDTOList);
    }


    @Override
    public ApiResponse<IngredientsResponseDTO> createIngredient(IngredientsRequestDTO ingredientsRequestDTO) {
        var ingredient = modelMapper.map(ingredientsRequestDTO, Ingredients.class);
        ingredientRepository.save(ingredient);

        var response = modelMapper.map(ingredient, IngredientsResponseDTO.class);

        return new ApiResponse<>("Ingredient created successfully", Estatus.SUCCESS, response);
    }

    @Override
    public ApiResponse<IngredientsResponseDTO> updateIngredient(int id, IngredientsRequestDTO ingredientsRequestDTO) {
        Optional<Ingredients> ingredientOptional = ingredientRepository.findById((int) id);
        if (ingredientOptional.isPresent()) {
            Ingredients ingredientToUpdate = ingredientOptional.get();
            modelMapper.map(ingredientsRequestDTO, ingredientToUpdate);
            ingredientRepository.save(ingredientToUpdate);
            IngredientsResponseDTO responseDTO = modelMapper.map(ingredientToUpdate, IngredientsResponseDTO.class);
            return new ApiResponse<>("Ingredient updated successfully", Estatus.SUCCESS, responseDTO);
        } else {
            return new ApiResponse<>("Ingredient not found", Estatus.ERROR, null);
        }
    }


    @Override
    public ApiResponse<Void> deleteIngredient(int id) {
        if (ingredientRepository.existsById((int) id)) {
            ingredientRepository.deleteById((int) id);
            return new ApiResponse<>("Ingredient deleted successfully", Estatus.SUCCESS, null);
        } else {
            return new ApiResponse<>("Ingredient not found", Estatus.ERROR, null);
        }
    }
}
