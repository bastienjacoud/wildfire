package com.project.wildfire.Converters;

import com.project.wildfire.Models.Abstract.AbstractCell;
import com.project.wildfire.Models.Cinder;
import com.project.wildfire.Models.Enums.CellStatus;
import com.project.wildfire.Models.Fire;
import com.project.wildfire.Models.Position;
import com.project.wildfire.Models.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Converters for cells
 */
public class CellConverter {

    /**
     * Convert a list of status to a list of cells. Used to initialize the grid.
     * @param statusList list of status.
     * @param columns Number of columns
     * @return List of cells
     */
    public static List<AbstractCell> ConvertStatusListToCells(List<CellStatus> statusList, int columns)
    {
        List<AbstractCell> res = new ArrayList<>();
        AtomicInteger x= new AtomicInteger(0);
        AtomicInteger y= new AtomicInteger(0);
        statusList.forEach(cellStatus -> {
            res.addLast(ConvertStatusToCell(cellStatus, new Position(x.getAndIncrement(),y.get())));
            if(x.get() == columns){
                x.set(0);
                y.incrementAndGet();
            }
        });
        return res;
    }

    /**
     * Convert status to cell. Used to initialize cells.
     * @param status Cell's status.
     * @param position Cell's position.
     * @return Initialized cell.
     */
    private static AbstractCell ConvertStatusToCell(CellStatus status, Position position){
        return switch (status) {
            case FIRE -> new Fire(position);
            case TREE -> new Tree(position);
            case CINDER -> new Cinder(position);
            case DEFAULT -> null;
        };
    }
}
