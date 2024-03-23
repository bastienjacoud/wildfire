import {CellStatus} from "./enums/cell-status";
import {Cell} from "./abstract/cell";

/**
 * Model for tree
 */
export class Tree extends Cell{

  /**
   * Constructor
   */
  constructor() {
    super(CellStatus.TREE);
  }
}
