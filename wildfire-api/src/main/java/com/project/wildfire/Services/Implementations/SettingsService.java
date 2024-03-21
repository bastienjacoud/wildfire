package com.project.wildfire.Services.Implementations;

import com.project.wildfire.Converters.CellConverter;
import com.project.wildfire.Models.Grid;
import com.project.wildfire.Models.DTO.GameDTO;
import com.project.wildfire.Models.Configuration.Settings;
import com.project.wildfire.Services.ISettingsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service for settings
 */
@Service
public class SettingsService implements ISettingsService {

    /**
     * Initial settings
     */
    @Autowired
    private Settings settings;

    /**
     * Method used to load settings (initial simulation state)
     * @return Initial game occurrence
     * @throws Exception
     */
    @Override
    public GameDTO loadGame() throws Exception {
        return new GameDTO(settings.getNbCols(), settings.getProbability(), new Grid(CellConverter.ConvertStatusListToCells(settings.getInitialState(),settings.getNbCols())), 0);
    }

    /**
     * Method used to save current game occurrence
     * @return Current game occurrence to save
     * @throws Exception
     */
    @Override
    public GameDTO saveSettings(GameDTO settings) {
        //TODO
        return null;
    }
}
