package com.project.wildfire.Services.Implementations;

import com.project.wildfire.Converters.CellConverter;
import com.project.wildfire.Models.Grid;
import com.project.wildfire.Models.DTO.GameDTO;
import com.project.wildfire.Models.Configuration.Settings;
import com.project.wildfire.Services.ISettingsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingsService implements ISettingsService {

    @Autowired
    private Settings settings;

    @Override
    public GameDTO loadGame() throws Exception {
        return new GameDTO(settings.getNbCols(), settings.getProbability(), new Grid(CellConverter.ConvertStatusListToCells(settings.getInitialState(),settings.getNbCols())), 0);
    }

    //TODO
    @Override
    public GameDTO saveSettings(GameDTO settings) {
        return null;
    }
}
