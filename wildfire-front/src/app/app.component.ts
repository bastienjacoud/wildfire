import {Component, OnInit} from '@angular/core';
import {TreeStatus} from "./models/enums/tree-status";
import {GridComponent} from "./components/grid/grid.component";
import {ActionsComponent} from "./components/actions/actions.component";
import {Tree} from "./models/tree";


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    GridComponent,
    ActionsComponent
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {

  title: string = 'wildfire-front';
  treeList: Tree[] = [
    {
      status : TreeStatus.NORMAL,
      posX : 0,
      posY : 0
    },
    {
      status : TreeStatus.NORMAL,
      posX : 1,
      posY : 0
    },
    {
      status : TreeStatus.NORMAL,
      posX : 2,
      posY : 0
    },
    {
      status : TreeStatus.NORMAL,
      posX : 0,
      posY : 1
    },
    {
      status : TreeStatus.NORMAL,
      posX : 1,
      posY : 1
    },
    {
      status : TreeStatus.NORMAL,
      posX : 2,
      posY : 1
    },
    {
      status : TreeStatus.NORMAL,
      posX : 0,
      posY : 2
    },
    {
      status : TreeStatus.FIRE,
      posX : 1,
      posY : 2
    },
    {
      status : TreeStatus.CINDER,
      posX : 2,
      posY : 2
    }
  ];
  nbColumns: number = 3;

  ngOnInit(): void {

  }
}
