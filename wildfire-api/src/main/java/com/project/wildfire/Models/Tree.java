package com.project.wildfire.Models;

import com.project.wildfire.Models.Abstract.AbstractCell;
import com.project.wildfire.Models.Enums.CellStatus;

import lombok.*;

/**
 * Class for tree
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Tree extends AbstractCell {

    /**
     * Default constructor
     */
    public Tree() {
        super(CellStatus.TREE);
    }

    /**
     * Builder used to create tree cell with position
     * @param pos Position
     */
    @Builder
    public Tree(Position pos){
        super(pos, CellStatus.TREE);
    }
}
