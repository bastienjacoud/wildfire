package com.project.wildfire.DTO;

import com.project.wildfire.Enums.TreeStatus;
import lombok.Data;

@Data
public class TreeDTO {
    private Integer posX;
    private Integer posY;
    private TreeStatus status;
}
