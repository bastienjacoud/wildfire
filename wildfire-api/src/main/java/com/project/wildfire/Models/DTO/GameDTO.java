package com.project.wildfire.Models.DTO;

import com.project.wildfire.Models.Grid;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO used for the game
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameDTO {

    /**
     * Number of columns
     */
    private int nbCols;

    /**
     * Probability
     */
    private double probability;

    /**
     * Grid
     */
    private Grid grid;

    /**
     * Step of the game
     */
    private int step;
}
