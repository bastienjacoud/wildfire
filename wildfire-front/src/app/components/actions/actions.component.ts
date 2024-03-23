import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {MatFabButton} from "@angular/material/button";
import {MatIcon} from "@angular/material/icon";
import {SettingsDialogComponent} from "./settings-dialog/settings-dialog.component";
import {MatDialog} from "@angular/material/dialog";
import {GameService} from "../../services/game.service";
import {HttpClientModule, HttpErrorResponse} from "@angular/common/http";
import {Game} from "../../models/game";
import {InformationDialogComponent} from "./information-dialog/information-dialog.component";
import {SettingsService} from "../../services/settings.service";
import {NgIf} from "@angular/common";

@Component({
  selector: 'app-actions',
  standalone: true,
  imports: [
    MatFabButton,
    MatIcon,
    HttpClientModule,
    NgIf
  ],
  templateUrl: './actions.component.html',
  styleUrl: './actions.component.css',
  providers: [GameService],
})
export class ActionsComponent implements OnInit{
  @Input() currentGame!: Game;
  @Output() currentGameChange = new EventEmitter<Game>();
  @Output() errorChange = new EventEmitter<string>();
  protected canReset: boolean = false;
  constructor(private dialog: MatDialog, private gameService: GameService, private settingsService: SettingsService) {}
  ngOnInit(): void {

  }
  openSettings() {
    //TODO
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

  protected nextStep() {
    this.runStep().add(
      () => this.checkEndGame()
    );
  }

  protected resetSettings(){
    return this.settingsService.getSettings().subscribe({
      next: (res: Game) => {
        this.currentGame = res;
        this.currentGameChange.emit(res);
        this.canReset = false;
        this.errorChange.emit('');
      },
      error: (err: HttpErrorResponse) => this.errorChange.emit(err.message)
    });
  }

  private runStep() {
    return this.gameService.runStep(this.currentGame).subscribe({
      next: (res: Game) => {
        this.currentGame = res;
        this.currentGameChange.emit(res);
        this.errorChange.emit('');
      },
      error: (err: HttpErrorResponse) => this.errorChange.emit(err.message)
    });
  }

  private checkEndGame() {
    return this.gameService.checkEndGame(this.currentGame).subscribe({
      next: (res: boolean) => {
        if(res){
          this.canReset = true;
          const dialogRef = this.dialog.open(InformationDialogComponent);
          dialogRef.afterClosed().subscribe(result => {
            if(result)
              this.resetSettings();
          });
        }
        this.errorChange.emit('');
      },
      error: (err: HttpErrorResponse) => this.errorChange.emit(err.message)
    });
  }
}
