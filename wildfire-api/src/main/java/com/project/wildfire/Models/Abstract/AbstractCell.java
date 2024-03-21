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

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@JsonTypeInfo( use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @Type(value = Tree.class, name = "TREE"),
        @Type(value = Cinder.class, name = "CINDER"),
        @Type(value = Fire.class, name = "FIRE")
})
public abstract class AbstractCell {
    private Position pos;
    @NonNull
    protected CellStatus type;
}
