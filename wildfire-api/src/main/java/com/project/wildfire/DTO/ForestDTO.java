package com.project.wildfire.DTO;

import com.project.wildfire.Enums.TreeStatus;
import lombok.Data;

import java.util.List;

@Data
public class ForestDTO {
    private List<TreeDTO> forest;
}
