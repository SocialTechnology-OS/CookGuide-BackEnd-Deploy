package com.cookguide.database.cookAPI.application.services.impl;

import com.cookguide.database.cookAPI.application.dto.request.RecipesRequestDTO;
import com.cookguide.database.cookAPI.application.dto.response.RecipesResponseDTO;
import com.cookguide.database.cookAPI.application.services.RecipesService;
import com.cookguide.database.cookAPI.domain.entities.Recipes;
import com.cookguide.database.cookAPI.infraestructure.repositories.RecipesRepository;
import com.cookguide.database.shared.exception.ValidationException;
import com.cookguide.database.shared.model.dto.response.ApiResponse;
import com.cookguide.database.shared.model.enums.Estatus;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecipesServiceImpl implements RecipesService {

    private final RecipesRepository recipesRepository;
    private final ModelMapper modelMapper;


    public RecipesServiceImpl(RecipesRepository recipesRepository, ModelMapper modelMapper) {
        this.recipesRepository = recipesRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse<List<RecipesResponseDTO>> getAllRecipes() {
        List<Recipes> recipesList = (List<Recipes>) recipesRepository.findAll();
        List<RecipesResponseDTO> recipesDTOList = recipesList.stream()
                .map(entity -> modelMapper.map(entity, RecipesResponseDTO.class))
                .collect(Collectors.toList());

        return new ApiResponse<>("All recipes fetched successfully", Estatus.SUCCESS, recipesDTOList);
    }
    @Override
    public ApiResponse<RecipesResponseDTO> createRecipes(RecipesRequestDTO recipesRequestDTO) {
        validateUniqueRecipes(recipesRequestDTO);
        var sportEvent = modelMapper.map(recipesRequestDTO, Recipes.class);
        recipesRepository.save(sportEvent);

        var response = modelMapper.map(sportEvent, RecipesResponseDTO.class);

        return new ApiResponse<>("Sport event created successfully", Estatus.SUCCESS, response);
    }

    @Override
    public ApiResponse<RecipesResponseDTO> updateRecipes(int id, RecipesRequestDTO recipesRequestDTO) {
        Optional<Recipes> recipeOptional = recipesRepository.findById((int) id);
        if (recipeOptional.isPresent()) {
            Recipes recipeToUpdate = recipeOptional.get();
            modelMapper.map(recipesRequestDTO, recipeToUpdate);
            recipesRepository.save(recipeToUpdate);
            RecipesResponseDTO responseDTO = modelMapper.map(recipeToUpdate, RecipesResponseDTO.class);
            return new ApiResponse<>("Recipe updated successfully", Estatus.SUCCESS, responseDTO);
        } else {
            return new ApiResponse<>("Recipe not found", Estatus.ERROR, null);
        }
    }

    @Override
    public ApiResponse<Void> deleteRecipes(int id) {
        if (recipesRepository.existsById((int) id)) {
            recipesRepository.deleteById((int) id);
            return new ApiResponse<>("Recipe deleted successfully", Estatus.SUCCESS, null);
        } else {
            return new ApiResponse<>("Recipe not found", Estatus.ERROR, null);
        }
    }

    void validateUniqueRecipes(RecipesRequestDTO recipesRequestDTO) {
        boolean exists = recipesRepository.existsByNameAndPreparationAndAndServingsAndTime(
                recipesRequestDTO.getName(),
                recipesRequestDTO.getPreparation(),
                recipesRequestDTO.getServings(),
                recipesRequestDTO.getTime()
        );

        if (exists) {
            throw new ValidationException("Recipe with the same name, type, time, and ingredients already exists");
        }
    }

}
