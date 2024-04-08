package com.project.wildfire.Models.Abstract;

import com.project.wildfire.Models.Cinder;
import com.project.wildfire.Models.Enums.CellStatus;
import com.project.wildfire.Models.Fire;
import com.project.wildfire.Models.Position;
import com.project.wildfire.Models.Tree;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

/**
 * Abstract class for cell
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @Type(value = Tree.class, name = CellStatus.Constant.TREE_VALUE),
        @Type(value = Cinder.class, name = CellStatus.Constant.CINDER_VALUE),
        @Type(value = Fire.class, name = CellStatus.Constant.FIRE_VALUE)
})
public abstract class AbstractCell {

    /**
     * Position
     */
    private Position pos;
}
