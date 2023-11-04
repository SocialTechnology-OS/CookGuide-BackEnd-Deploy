package com.cookguide.database.repository;

import com.cookguide.database.model.Preference;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PreferenceRepository extends CrudRepository<Preference, Integer>
{
}
