package com.project.wildfire.Models;

import com.project.wildfire.Models.Abstract.AbstractCell;
import com.project.wildfire.Models.Enums.CellStatus;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Tree extends AbstractCell {
    @Builder
    public Tree(Position pos){
        super(pos, CellStatus.TREE);
    }
}
