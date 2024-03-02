package com.project.wildfire.Models;

import com.project.wildfire.Models.Abstract.AbstractCell;
import com.project.wildfire.Models.Enums.CellStatus;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Fire extends AbstractCell {
    @Builder
    public Fire(Position pos){
        super(pos, CellStatus.FIRE);
    }
}
