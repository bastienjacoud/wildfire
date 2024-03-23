import {Position} from "../position";
import {CellStatus} from "../enums/cell-status";
import {Model} from "../interface/model";

/**
 * Model for cell
 */
export abstract class Cell implements Model{

  /**
   * Constructor
   * @param status Cell's status
   * @protected
   */
  protected constructor(status:CellStatus) {
    this.type = status;
  }

  /**
   * Position
   */
  pos:Position = new Position();

  /**
   * Status
   */
  type:CellStatus = CellStatus.DEFAULT;

  /**
   * Method to hydrate object from json
   * @param json Json object
   */
  fromJSON(json: any): any {
    this.pos=json.pos;
    this.type=json.status;
  }
}
