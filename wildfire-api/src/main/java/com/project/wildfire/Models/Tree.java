package com.project.wildfire.Models;

import com.project.wildfire.Models.Abstract.AbstractCell;
import com.project.wildfire.Models.Enums.CellStatus;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Tree extends AbstractCell {
    public Tree() {
        super(CellStatus.TREE);
    }

    @Builder
    public Tree(Position pos){
        super(pos, CellStatus.TREE);
    }
}
