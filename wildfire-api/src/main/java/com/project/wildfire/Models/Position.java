package com.project.wildfire.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Class for position
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Position {

    /**
     * Position in the horizontal axis
     */
    private int posX;

    /**
     * Position in the vertical axis
     */
    private int posY;
}
