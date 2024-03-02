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

public class CellConverter {
    public static List<AbstractCell> ConvertStatusListToCells(List<CellStatus> statusList, int columns)
    {
        List<AbstractCell> res = new ArrayList<>();
        AtomicInteger x= new AtomicInteger(0);
        AtomicInteger y= new AtomicInteger(0);
        statusList.forEach(cellStatus -> {
            res.addLast(ConvertStatusToCell(cellStatus, new Position(x.getAndIncrement(),y.get())));
            if(x.get() ==columns){
                x.set(0);
                y.incrementAndGet();
            }
        });
        return res;
    }

    private static AbstractCell ConvertStatusToCell(CellStatus status, Position position){
        return switch (status) {
            case FIRE -> Fire.builder().pos(position).build();
            case TREE -> Tree.builder().pos(position).build();
            case CINDER -> Cinder.builder().pos(position).build();
            case DEFAULT -> null;
        };
    }
}
