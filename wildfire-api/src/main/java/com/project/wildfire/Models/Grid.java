package com.project.wildfire.Models;

import com.project.wildfire.Models.Abstract.AbstractCell;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grid {
    private List<AbstractCell> cellList;
}
