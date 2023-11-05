package com.cookguide.database.repository;

import com.cookguide.database.model.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe,Long > {
}
