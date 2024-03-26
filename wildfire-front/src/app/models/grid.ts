import {Cell} from "./abstract/cell";
import {Model} from "./interface/model";
import {Tree} from "./tree";

/**
 * Model for grid
 */
export class Grid implements Model{

  /**
   * Constructor
   */
  constructor() {}

  /**
   * List of cells
   */
  cellList:Array<Cell> = new Array<Cell>();

  /**
   * Method to hydrate object from json
   * @param json Json object
   */
  fromJSON(json: any): any {
    this.cellList = json.cellList;
  }
}
