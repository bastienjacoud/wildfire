import {Grid} from "./grid";
import {Model} from "./interface/model";

/**
 * Model for game
 */
export class Game implements Model{

  /**
   * Constructor
   */
  constructor() {}

  /**
   * Number of columns
   */
  nbCols: number = 0;

  /**
   * Probability
   */
  probability: number = 0;

  /**
   * Grid
   */
  grid: Grid = new Grid();

  /**
   * Step
   */
  step: number = 0;

  /**
   * Method to hydrate object from json
   * @param json Json object
   */
  fromJSON(json: any): any {
    this.nbCols=json.nbCols;
    this.probability=json.probability;
    this.grid.fromJSON(json.grid);
    this.step=json.step;
  }
}
