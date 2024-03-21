package com.project.wildfire.Services;

import com.project.wildfire.Models.DTO.GameDTO;

/**
 * Interface for game service
 */
public interface IGameService {

    /**
     * Return next game occurrence, after running one step of the simulation
     * @param currentGame Current game iteration
     * @return Next game iteration
     * @throws Exception
     */
    GameDTO goNextStep(GameDTO currentGame) throws Exception;

    /**
     * Check if the simulation is finished or not.
     * @param currentGame Current game iteration
     * @return Boolean that specify if the simulation is ended or not.
     * @throws Exception
     */
    boolean checkEndGame(GameDTO currentGame) throws Exception;
}
