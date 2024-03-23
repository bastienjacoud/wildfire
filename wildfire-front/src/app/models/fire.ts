import {Cell} from "./abstract/cell";
import {CellStatus} from "./enums/cell-status";

/**
 * Model for fire
 */
export class Fire extends Cell{

  /**
   * Constructor
   */
  constructor() {
    super(CellStatus.FIRE);
  }
}
