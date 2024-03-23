package com.project.wildfire.Models.Configuration;

import com.project.wildfire.Models.Enums.CellStatus;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import java.util.List;

/**
 * Settings loaded from configuration file
 */
@Configuration
@ConfigurationProperties(prefix = "app.settings")
@Data
public class Settings {

    /**
     * Number of columns
     */
    private int nbCols;

    /**
     * Probability
     */
    private Double probability;

    /**
     * Initial state of the grid
     */
    private List<CellStatus> initialState;
}
