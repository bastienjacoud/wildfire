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
     * @throws NullPointerException Exception
     */
    @Override
    public GameDTO loadGame() throws NullPointerException {
        /* Vérifie le chargement des paramètres */
        if(settings == null){
            throw new NullPointerException("Erreur lors du chargement du fichier de configuration.");
        } else if (settings.getInitialState() == null || settings.getInitialState().isEmpty()) {
            throw new NullPointerException("Erreur lors du chargement de la configuration initiale de la grille.");
        }

        /* Initialise et retourne la game à partir des paramètres */
        return new GameDTO(settings.getNbCols(), settings.getProbability(), new Grid(CellConverter.ConvertStatusListToCells(settings.getInitialState(),settings.getNbCols())), 0);
    }

    /**
     * Method used to save current game occurrence
     * @return Current game occurrence to save
     * @throws Exception
     */
    @Override
    public GameDTO saveSettings(GameDTO settings) throws Exception {
        //TODO
        return null;
    }
}
