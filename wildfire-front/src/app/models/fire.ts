import {Cell} from "./abstract/cell";
import {CellStatus} from "./enums/cell-status";

export class Fire extends Cell{
  constructor() {
    super(CellStatus.FIRE);
  }
}
