package com.cookguide.database.cookAPI.application.services.impl;

import com.cookguide.database.cookAPI.application.services.PreferenceService;
import com.cookguide.database.cookAPI.domain.entities.Preference;
import com.cookguide.database.cookAPI.infraestructure.repositories.PreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreferenceServiceImpl implements PreferenceService {

    @Autowired
    private PreferenceRepository preferenceRepository;

    @Override
    public Preference createPreference(Preference preference){
        return preferenceRepository.save(preference);
    }
}
