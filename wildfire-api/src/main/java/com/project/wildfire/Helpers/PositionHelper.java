package com.project.wildfire.Helpers;

import com.project.wildfire.Models.Position;

/**
 * Helper for position
 */
public class PositionHelper {

    /**
     * Method that check if a position is adjacent to another.
     * @param pos1 first position
     * @param pos2 second position
     * @return true if first position is closed by second one.
     */
    public static boolean isAdjacent(Position pos1, Position pos2){
        return ((Math.abs(pos1.getPosX() - pos2.getPosX()) == 1) && pos1.getPosY() == pos2.getPosY()) || (pos1.getPosX() == pos2.getPosX() && (Math.abs(pos1.getPosY() - pos2.getPosY()) == 1));
    }
}
