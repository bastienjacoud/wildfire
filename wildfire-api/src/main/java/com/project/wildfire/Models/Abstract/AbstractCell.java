package com.project.wildfire.Models.Abstract;

import com.project.wildfire.Models.Enums.CellStatus;
import com.project.wildfire.Models.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
public abstract class AbstractCell {
    private Position pos;
    protected CellStatus type;
}
