import {Model} from "./interface/model";

export class Position implements Model{
  constructor() {}

  posX: number=0;
  posY: number=0;

  hydrateFromJSON(json: any): any {
    this.posX=json.posX;
    this.posY=json.posY;
  }

}
