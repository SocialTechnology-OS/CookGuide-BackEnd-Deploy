package com.cookguide.database.cookAPI.infraestructure.repositories;

import com.cookguide.database.cookAPI.domain.entities.Recipes;
import org.springframework.data.repository.CrudRepository;

public interface RecipesRepository extends CrudRepository<Recipes,Integer > {
    boolean existsByNameAndPreparationAndAndServingsAndTime(String name, String preparation, String servings, String time);
}
