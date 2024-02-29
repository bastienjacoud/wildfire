package com.project.wildfire.Services;

import com.project.wildfire.DTO.SettingsDTO;

public interface ISettingsService {

    SettingsDTO findFirst() throws Exception;
    SettingsDTO save(SettingsDTO settings);
}
