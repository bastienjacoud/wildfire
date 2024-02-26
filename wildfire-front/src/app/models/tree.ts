import {TreeStatus} from "./enums/tree-status";

export class Tree {
  constructor() {
  }

  status: TreeStatus = TreeStatus.DEFAULT;
  posX: number = 0;
  posY: number = 0;
}
