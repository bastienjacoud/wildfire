import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {MatFabButton} from "@angular/material/button";
import {MatIcon} from "@angular/material/icon";
import {SettingsDialogComponent} from "./settings-dialog/settings-dialog.component";
import {MatDialog} from "@angular/material/dialog";
import {GameService} from "../../services/game.service";
import {HttpClientModule} from "@angular/common/http";
import {Game} from "../../models/game";

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
  @Input() currentGame!: Game;
  @Output() currentGameChange = new EventEmitter<Game>();
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
    this.gameService.runStep(this.currentGame).subscribe({
      next: (res: Game) => this.currentGameChange.emit(res),
      error: (err) => console.log("Erreur : "+ err)
    });
  }
}
