import {Component, Input, OnInit} from '@angular/core';
import {MatCard, MatCardMdImage} from "@angular/material/card";
import {MatGridList, MatGridTile} from "@angular/material/grid-list";
import {NgForOf, NgIf, NgOptimizedImage} from "@angular/common";
import {Tree} from "../../models/tree";
import {CellStatus} from "../../models/enums/cell-status";

@Component({
  selector: 'app-grid',
  standalone: true,
  imports: [
    MatCard,
    MatCardMdImage,
    MatGridList,
    MatGridTile,
    NgForOf,
    NgIf,
    NgOptimizedImage
  ],
  templateUrl: './grid.component.html',
  styleUrl: './grid.component.css'
})
export class GridComponent implements OnInit {
  @Input() treeList!: Tree[];
  @Input() nbColumns!: number;

  protected readonly TreeStatus = CellStatus;

  ngOnInit(): void {

  }
}
