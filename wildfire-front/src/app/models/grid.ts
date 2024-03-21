import {Cell} from "./abstract/cell";
import {Model} from "./interface/model";
import {Tree} from "./tree";

export class Grid implements Model{
  constructor() {}

  cellList:Array<Cell> = new Array<Cell>();

  fromJSON(json: any): any {
    this.cellList = json.cellList;
  }
}
