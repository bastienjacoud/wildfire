import {Position} from "../position";
import {CellStatus} from "../enums/cell-status";
import {Model} from "../interface/model";

export abstract class Cell implements Model{

  protected constructor() {}

  pos:Position = new Position();
  status:CellStatus = CellStatus.DEFAULT;

  hydrateFromJSON(json: any): any {
    this.pos=json.pos;
    this.status=json.status;
  }
}
