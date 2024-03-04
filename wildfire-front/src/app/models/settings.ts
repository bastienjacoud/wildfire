import {Grid} from "./grid";
import {Model} from "./interface/model";

export class Settings implements Model{
  constructor() {}

  nbCols: number = 0;
  nbRows: number = 0;
  probability: number = 0;
  grid: Grid = new Grid();

  fromJSON(json: any): any {
    this.nbCols=json.nbCols;
    this.nbRows=json.nbRows;
    this.probability=json.probability;
    this.grid.fromJSON(json.grid);
  }
}
