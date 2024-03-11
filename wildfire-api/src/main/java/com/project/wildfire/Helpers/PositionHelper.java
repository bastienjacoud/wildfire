package com.project.wildfire.Helpers;

import com.project.wildfire.Models.Abstract.AbstractCell;
import com.project.wildfire.Models.Position;

import java.util.List;

public class PositionHelper {
    public static boolean isAdjacent(Position pos1, Position pos2){
        return ((Math.abs(pos1.getPosX() - pos2.getPosX()) == 1) && pos1.getPosY() == pos2.getPosY()) || (pos1.getPosX() == pos2.getPosX() && (Math.abs(pos1.getPosY() - pos2.getPosY()) == 1));
    }

    public static boolean samePosition(Position pos1, Position pos2){
        return pos1.getPosX() == pos2.getPosX() && pos1.getPosY() == pos2.getPosY();
    }
}
