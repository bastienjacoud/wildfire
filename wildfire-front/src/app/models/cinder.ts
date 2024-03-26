import {Cell} from "./abstract/cell";
import {CellStatus} from "./enums/cell-status";

/**
 * Model for cinder
 */
export class Cinder extends Cell{

  /**
   * Constructor
   */
  constructor() {
    super(CellStatus.CINDER);
  }
}
