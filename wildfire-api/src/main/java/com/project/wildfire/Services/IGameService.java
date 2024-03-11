package com.project.wildfire.Services;

import com.project.wildfire.Models.DTO.GridDTO;
import com.project.wildfire.Models.DTO.SettingsDTO;

public interface IGameService {
    GridDTO goNextStep(GridDTO grid) throws Exception;
}
