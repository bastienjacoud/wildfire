package com.project.wildfire.DTO;

import com.project.wildfire.Models.Abstract.AbstractCell;
import lombok.Data;

import java.util.List;

@Data
public class GridDTO {
    private List<AbstractCell> cellList;
}
