package com.project.wildfire.Services;

import com.project.wildfire.Models.DTO.GameDTO;

public interface ISettingsService {

    GameDTO loadGame() throws Exception;
    GameDTO saveSettings(GameDTO settings);
}
