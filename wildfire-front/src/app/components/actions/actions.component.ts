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

/**
 * Action component
 */
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

  /**
   * Game
   */
  @Input() currentGame!: Game;

  /**
   * Event emitter for game
   */
  @Output() currentGameChange = new EventEmitter<Game>();

  /**
   * Event emitter for error
   */
  @Output() errorChange = new EventEmitter<string>();

  /**
   * Indicate if grid can be reset
   * @protected
   */
  protected canReset: boolean = false;

  /**
   * Constructor
   * @param dialog Dialog
   * @param gameService Game service
   * @param settingsService Settings service
   */
  constructor(private dialog: MatDialog, private gameService: GameService, private settingsService: SettingsService) {}

  /**
   * Component initialisation method
   */
  ngOnInit(): void {

  }

  /**
   * Open settings modal
   */
  openSettings() {
    //TODO Draft only
    this.dialog.open(SettingsDialogComponent, {
      data: {
        probability: 0.5,
        columnNb : 3,
        rowNb : 3
      }
    });
  }

  /**
   * Automatic simulation
   */
  launch() {
    //TODO
  }

  /**
   * Step by step simulation
   * @protected
   */
  protected nextStep() {
    this.runStep().add(
      () => this.checkEndGame()
    );
  }

  /**
   * Reset game from settings
   * @protected
   */
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

  /**
   * Run one step
   * @private
   */
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

  /**
   * Check if game is ended
   * @private
   */
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
