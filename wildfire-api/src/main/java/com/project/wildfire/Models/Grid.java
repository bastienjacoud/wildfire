package com.project.wildfire.Models;

import com.project.wildfire.Models.Abstract.AbstractCell;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * Class for Grid
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grid {

    /**
     * List of cells
     */
    private List<AbstractCell> cellList;
}
