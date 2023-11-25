package com.cookguide.database.cookAPI.domain.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

@Data
@Entity
@Table(name = "recipe_ingredients")
public class RecipeIngredients {

    @EmbeddedId
    private RecipeIngredientKey id;

    @ManyToOne
    @MapsId("recipeId")
    @JoinColumn(name = "recipe_id")
    private Recipes recipe;

    @ManyToOne
    @MapsId("ingredientId")
    @JoinColumn(name = "ingredient_id")
    private Ingredients ingredient;

    @Getter
    @Column(name = "amount")
    private double amount;

    @Getter
    @Column(name = "measure")
    private String measure;

}

