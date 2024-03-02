import {CellStatus} from "./enums/cell-status";

export class Tree {
  constructor() {
  }

  status: CellStatus = CellStatus.DEFAULT;
  posX: number = 0;
  posY: number = 0;
}
