package com.project.wildfire.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SettingsDTO {
    private Integer nbCols;
    private Integer nbRows;
    private Double probability;
}
