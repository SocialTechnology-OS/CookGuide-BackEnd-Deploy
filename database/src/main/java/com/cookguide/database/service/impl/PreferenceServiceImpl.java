package com.cookguide.database.service.impl;

import com.cookguide.database.model.Preference;
import com.cookguide.database.repository.PreferenceRepository;
import com.cookguide.database.service.PreferenceService;
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
