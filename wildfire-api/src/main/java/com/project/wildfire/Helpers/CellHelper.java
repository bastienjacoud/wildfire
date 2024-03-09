package com.project.wildfire.Helpers;

import com.project.wildfire.Models.Abstract.AbstractCell;
import com.project.wildfire.Models.Cinder;
import com.project.wildfire.Models.Enums.CellStatus;
import com.project.wildfire.Models.Fire;
import com.project.wildfire.Models.Position;
import com.project.wildfire.Models.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CellHelper {
    public static List<AbstractCell> getAdjacentCells(List<AbstractCell> cellList, AbstractCell cell){
        return cellList.stream().filter(c->PositionHelper.isAdjacent(c.getPos(),cell.getPos())).toList();
    }
}
