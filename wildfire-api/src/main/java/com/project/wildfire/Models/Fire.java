package com.project.wildfire.Models;

import com.project.wildfire.Models.Abstract.AbstractCell;
import com.project.wildfire.Models.Enums.CellStatus;

import lombok.*;

/**
 * Class for fire
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Fire extends AbstractCell {

    /**
     * Default constructor
     */
    public Fire() {
        super(CellStatus.FIRE);
    }

    /**
     * Builder used to create fire cell with position
     * @param pos Position
     */
    @Builder
    public Fire(Position pos){
        super(pos, CellStatus.FIRE);
    }
}
