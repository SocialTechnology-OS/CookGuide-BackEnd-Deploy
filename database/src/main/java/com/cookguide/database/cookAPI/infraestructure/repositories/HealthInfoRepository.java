package com.cookguide.database.cookAPI.infraestructure.repositories;

import com.cookguide.database.cookAPI.domain.entities.Health_info;
import org.springframework.data.repository.CrudRepository;

public interface HealthInfoRepository extends CrudRepository<Health_info, Integer> {

}
