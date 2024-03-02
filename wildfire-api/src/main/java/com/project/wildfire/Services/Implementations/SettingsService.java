package com.project.wildfire.Services.Implementations;

import com.project.wildfire.Converters.CellConverter;
import com.project.wildfire.Models.DTO.GridDTO;
import com.project.wildfire.Models.DTO.SettingsDTO;
import com.project.wildfire.Models.Configuration.Settings;
import com.project.wildfire.Services.ISettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingsService implements ISettingsService {

    @Autowired
    private Settings settings;

    @Override
    public SettingsDTO findFirst() throws Exception {
        //TODO Ajouter vérifications sur le paramétrage (cohérence taille et grille initiale)
        GridDTO grid = new GridDTO(CellConverter.ConvertStatusListToCells(settings.getInitialState(),settings.getLength()), 0);
        return new SettingsDTO(settings.getLength(), settings.getHeight(), settings.getProbability(), grid);
    }

    @Override
    public SettingsDTO save(SettingsDTO settings) {
        return null;
    }
}
