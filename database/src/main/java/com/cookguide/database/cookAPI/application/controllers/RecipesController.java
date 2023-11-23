package com.cookguide.database.cookAPI.application.controllers;

import com.cookguide.database.cookAPI.application.dto.request.RecipesRequestDTO;
import com.cookguide.database.cookAPI.application.dto.response.RecipesResponseDTO;
import com.cookguide.database.cookAPI.application.services.RecipesService;
import com.cookguide.database.shared.model.dto.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Recipes", description = "Recipes API")
@RestController
@RequestMapping("/api/v1/cookguide")
public class RecipesController {

    private final RecipesService recipesService;

    public RecipesController(RecipesService recipesService) {
        this.recipesService = recipesService;
    }

    @Operation(summary = "Get all recipes")
    @GetMapping("/recipes")
    public ResponseEntity<ApiResponse<List<RecipesResponseDTO>>> getAllRecipes() {
        var res = recipesService.getAllRecipes();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Operation(summary = "Create a new recipe")
    @PostMapping("/recipes")
    public ResponseEntity<ApiResponse<RecipesResponseDTO>> createRecipes(@RequestBody RecipesRequestDTO recipesRequestDTO){
        var res = recipesService.createRecipes(recipesRequestDTO);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @Operation(summary = "Update an existing recipe")
    @PutMapping("/recipes/{id}")
    public ResponseEntity<ApiResponse<RecipesResponseDTO>> updateRecipes(@PathVariable int id, @RequestBody RecipesRequestDTO recipesRequestDTO) {
        var res = recipesService.updateRecipes(id, recipesRequestDTO);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Operation(summary = "Delete a recipe")
    @DeleteMapping("/recipes/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteRecipes(@PathVariable int id) {
        var res = recipesService.deleteRecipes(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
