package com.cookguide.database.cookAPI.application.controllers;

import com.cookguide.database.cookAPI.application.dto.request.IngredientsRequestDTO;
import com.cookguide.database.cookAPI.application.dto.response.IngredientsResponseDTO;
import com.cookguide.database.cookAPI.application.services.IngredientsService;
import com.cookguide.database.shared.model.dto.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Ingredients", description = "Ingredients API")
@RestController
@RequestMapping("/api/v1/cookguide")
public class IngredientsController {

    private final IngredientsService ingredientsService;

    public IngredientsController(IngredientsService ingredientsService) {
        this.ingredientsService = ingredientsService;
    }

    @Operation(summary = "Get all ingredients")
    @GetMapping("/ingredients")
    public ResponseEntity<ApiResponse<List<IngredientsResponseDTO>>> getAllIngredients() {
        var res = ingredientsService.getAllIngredients();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Operation(summary = "Create a new ingredient")
    @PostMapping("/ingredients")
    public ResponseEntity<ApiResponse<IngredientsResponseDTO>> createIngredient(@RequestBody IngredientsRequestDTO ingredientsRequestDTO) {
        var res = ingredientsService.createIngredient(ingredientsRequestDTO);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @Operation(summary = "Update an existing ingredient")
    @PutMapping("/ingredients/{id}")
    public ResponseEntity<ApiResponse<IngredientsResponseDTO>> updateIngredient(@PathVariable int id, @RequestBody IngredientsRequestDTO ingredientsRequestDTO) {
        var res = ingredientsService.updateIngredient(id, ingredientsRequestDTO);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Operation(summary = "Delete an ingredient")
    @DeleteMapping("/ingredients/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteIngredient(@PathVariable int id) {
        var res = ingredientsService.deleteIngredient(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
