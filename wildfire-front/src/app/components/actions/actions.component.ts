import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {MatFabButton} from "@angular/material/button";
import {MatIcon} from "@angular/material/icon";
import {SettingsDialogComponent} from "./settings-dialog/settings-dialog.component";
import {MatDialog} from "@angular/material/dialog";
import {SettingsService} from "../../services/settings.service";
import {GameService} from "../../services/game.service";
import {Cell} from "../../models/abstract/cell";
import {Grid} from "../../models/grid";
import {HttpClientModule} from "@angular/common/http";

@Component({
  selector: 'app-actions',
  standalone: true,
  imports: [
    MatFabButton,
    MatIcon,
    HttpClientModule
  ],
  templateUrl: './actions.component.html',
  styleUrl: './actions.component.css',
  providers: [GameService],
})
export class ActionsComponent implements OnInit{
  @Input() currentGrid!: Grid;
  @Output() currentGridChange = new EventEmitter<Grid>();
  constructor(public dialog: MatDialog, private gameService: GameService) {}
  ngOnInit(): void {

  }
  openSettings() {
    this.dialog.open(SettingsDialogComponent, {
      data: {
        probability: 0.5,
        columnNb : 3,
        rowNb : 3
      }
    });
  }

  launch() {
    //TODO
  }

  runStep() {
    this.gameService.runStep(this.currentGrid).subscribe({
      next: (grid: Grid) => this.currentGridChange.emit(grid),
      error: (err) => console.log("Erreur : "+ err)
    });
  }
}
