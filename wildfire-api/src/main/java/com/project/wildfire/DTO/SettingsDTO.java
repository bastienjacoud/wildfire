package com.project.wildfire.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SettingsDTO {
    private int nbCols;
    private int nbRows;
    private double probability;
}
