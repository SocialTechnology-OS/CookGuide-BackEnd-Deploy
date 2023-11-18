package com.cookguide.database.cookAPI.infraestructure.repositories;

import com.cookguide.database.cookAPI.domain.entities.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
}
