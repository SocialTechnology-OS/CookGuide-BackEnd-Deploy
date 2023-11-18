package com.cookguide.database.cookAPI.infraestructure.repositories;

import com.cookguide.database.cookAPI.domain.entities.Preference;
import org.springframework.data.repository.CrudRepository;

public interface PreferenceRepository extends CrudRepository<Preference, Integer>
{
}
