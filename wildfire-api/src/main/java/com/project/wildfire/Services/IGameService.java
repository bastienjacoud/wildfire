package com.project.wildfire.Services;

import com.project.wildfire.Models.DTO.GameDTO;

public interface IGameService {
    GameDTO goNextStep(GameDTO currentGame) throws Exception;

    boolean checkEndGame(GameDTO currentGame) throws Exception;
}
