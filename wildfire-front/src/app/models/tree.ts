import {CellStatus} from "./enums/cell-status";
import {Cell} from "./abstract/cell";

export class Tree extends Cell{
  constructor() {
    super(CellStatus.TREE);
  }
}
