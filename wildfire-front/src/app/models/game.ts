import {Grid} from "./grid";
import {Model} from "./interface/model";

export class Game implements Model{
  constructor() {}

  nbCols: number = 0;
  probability: number = 0;
  grid: Grid = new Grid();
  step: number = 0;

  fromJSON(json: any): any {
    this.nbCols=json.nbCols;
    this.probability=json.probability;
    this.grid.fromJSON(json.grid);
    this.step=json.step;
  }
}
