package com.project.wildfire.Models;

import com.project.wildfire.Models.Abstract.AbstractCell;

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
        super();
    }

    /**
     * Builder used to create tree cell with position
     * @param pos Position
     */
    @Builder
    public Tree(Position pos){
        super(pos);
    }
}
