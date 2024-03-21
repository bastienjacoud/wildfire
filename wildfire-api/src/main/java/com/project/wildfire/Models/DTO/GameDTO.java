package com.project.wildfire.Models.DTO;

import com.project.wildfire.Models.Grid;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameDTO {
    private int nbCols;
    private double probability;
    private Grid grid;
    private int step;
}
