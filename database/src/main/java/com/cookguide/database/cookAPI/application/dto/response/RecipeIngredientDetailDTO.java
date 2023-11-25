package com.cookguide.database.cookAPI.application.dto.response;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RecipeIngredientDetailDTO {

    private int recipeId;
    private int ingredientId;
    private double amount;
    private String measure;

    public RecipeIngredientDetailDTO() {
    }

    public RecipeIngredientDetailDTO(int recipeId, int ingredientId, double amount, String measure) {
        this.recipeId = recipeId;
        this.ingredientId = ingredientId;
        this.amount = amount;
        this.measure = measure;
    }

}
