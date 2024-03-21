package com.project.wildfire.Services;

import com.project.wildfire.Models.DTO.GameDTO;

/**
 * Interface for settings service
 */
public interface ISettingsService {

    /**
     * Method used to load settings (initial simulation state)
     * @return Initial game occurrence
     * @throws Exception
     */
    GameDTO loadGame() throws Exception;

    /**
     * Method used to save current game occurrence
     * @return Current game occurrence to save
     * @throws Exception
     */
    GameDTO saveSettings(GameDTO settings);
}
