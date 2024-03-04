import {Cell} from "./abstract/cell";
import {CellStatus} from "./enums/cell-status";

export class Cinder extends Cell{
  constructor() {
    super(CellStatus.CINDER);
  }
}
