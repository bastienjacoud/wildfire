import {Component, Input, OnInit} from '@angular/core';
import {MatCard, MatCardMdImage} from "@angular/material/card";
import {MatGridList, MatGridTile} from "@angular/material/grid-list";
import {NgForOf, NgIf, NgOptimizedImage} from "@angular/common";
import {CellStatus} from "../../models/enums/cell-status";
import {Cell} from "../../models/abstract/cell";

/**
 * Grid component
 */
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

  /**
   * List of cells
   */
  @Input() cellList!: Cell[];

  /**
   * Number of columns
   */
  @Input() nbColumns!: number;

  /**
   * Status enumeration
   * @protected
   */
  protected readonly TreeStatus = CellStatus;

  /**
   * Component initialisation method
   */
  ngOnInit(): void {

  }
}
