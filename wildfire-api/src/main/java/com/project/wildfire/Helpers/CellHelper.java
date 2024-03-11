package com.project.wildfire.Helpers;

import com.project.wildfire.Models.Abstract.AbstractCell;

import java.util.List;

public class CellHelper {
    public static List<AbstractCell> getAdjacentCells(List<AbstractCell> cellList, AbstractCell cell){
        return cellList.stream().filter(c->PositionHelper.isAdjacent(c.getPos(),cell.getPos())).toList();
    }
}
