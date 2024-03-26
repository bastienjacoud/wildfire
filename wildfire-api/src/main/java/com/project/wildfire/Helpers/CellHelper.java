package com.project.wildfire.Helpers;

import com.project.wildfire.Models.Abstract.AbstractCell;

import java.util.List;

/**
 * Helper for cells
 */
public class CellHelper {

    /**
     * Method used to get adjacent cells
     * @param cellList list of cells in the grid
     * @param cell Specified cell
     * @return Adjacent cells of a specified one
     */
    public static List<AbstractCell> getAdjacentCells(List<AbstractCell> cellList, AbstractCell cell){
        return cellList.stream().filter(c->PositionHelper.isAdjacent(c.getPos(),cell.getPos())).toList();
    }
}
