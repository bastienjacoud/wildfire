package com.project.wildfire.Models.DTO;

import com.project.wildfire.Models.Abstract.AbstractCell;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GridDTO {
    private List<AbstractCell> cellList;
    private int step;
}
