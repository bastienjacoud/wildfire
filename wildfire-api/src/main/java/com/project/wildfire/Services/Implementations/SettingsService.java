package com.project.wildfire.Services.Implementations;

import com.project.wildfire.DTO.SettingsDTO;
import com.project.wildfire.Models.Settings;
import com.project.wildfire.Services.ISettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingsService implements ISettingsService {

    @Autowired
    private Settings settings;

    @Override
    public SettingsDTO findFirst() throws Exception {
        return new SettingsDTO(settings.getLength(), settings.getHeight(), settings.getProbability());
    }

    @Override
    public SettingsDTO save(SettingsDTO settings) {
        return null;
    }
}
