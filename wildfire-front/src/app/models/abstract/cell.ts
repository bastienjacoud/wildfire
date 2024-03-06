import {Position} from "../position";
import {CellStatus} from "../enums/cell-status";
import {Model} from "../interface/model";

export abstract class Cell implements Model{

  protected constructor(status:CellStatus) {
    this.type = status;
  }

  pos:Position = new Position();
  type:CellStatus = CellStatus.DEFAULT;

  fromJSON(json: any): any {
    this.pos=json.pos;
    this.type=json.status;
  }
}
