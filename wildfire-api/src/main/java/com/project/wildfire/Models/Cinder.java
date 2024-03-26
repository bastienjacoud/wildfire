package com.project.wildfire.Models;

import com.project.wildfire.Models.Abstract.AbstractCell;
import com.project.wildfire.Models.Enums.CellStatus;

import lombok.*;

/**
 * Class for cinder
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Cinder extends AbstractCell {

    /**
     * Default constructor
     */
    public Cinder() {
        super(CellStatus.CINDER);
    }

    /**
     * Builder used to create cinder cell with position
     * @param pos Position
     */
    @Builder
    public Cinder(Position pos){
        super(pos, CellStatus.CINDER);
    }
}
