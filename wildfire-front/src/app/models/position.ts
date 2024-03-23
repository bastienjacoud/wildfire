import {Model} from "./interface/model";

/**
 * Model for position
 */
export class Position implements Model{

  /**
   * Constructor
   */
  constructor() {}

  /**
   * Position in horizontal axis
   */
  posX: number=0;

  /**
   * Position in vertical axis
   */
  posY: number=0;

  /**
   * Method to hydrate object from json
   * @param json Json object
   */
  fromJSON(json: any): any {
    this.posX=json.posX;
    this.posY=json.posY;
  }
}
