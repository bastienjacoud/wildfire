package com.project.wildfire.Models.DTO;

import com.project.wildfire.Models.Abstract.AbstractCell;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GridDTO {
    private List<AbstractCell> cellList;
    private int step;
}
