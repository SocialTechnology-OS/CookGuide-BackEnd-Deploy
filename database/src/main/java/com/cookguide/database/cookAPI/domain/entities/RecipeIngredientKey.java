package com.cookguide.database.cookAPI.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class RecipeIngredientKey implements Serializable {

    @Column(name = "recipe_id")
    private int recipeId;

    @Column(name = "ingredient_id")
    private int ingredientId;

    // Getters y setters, hashCode, equals
}
