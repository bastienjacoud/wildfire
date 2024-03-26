import {Component, OnInit} from '@angular/core';
import {GridComponent} from "./components/grid/grid.component";
import {ActionsComponent} from "./components/actions/actions.component";
import {SettingsService} from "./services/settings.service";
import {HttpClientModule, HttpErrorResponse} from "@angular/common/http";
import {Game} from "./models/game";
import {NgIf} from "@angular/common";

/**
 * Application component
 */
@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    GridComponent,
    ActionsComponent,
    HttpClientModule,
    NgIf
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
  providers: [SettingsService],
})
export class AppComponent implements OnInit {

  /**
   * Title
   */
  title: string = 'wildfire-front';

  /**
   * Game
   */
  game: Game = new Game();

  /**
   * Loading status
   */
  loading = false;

  /**
   * Error message
   */
  error = '';

  /**
   * Constructor
   * @param settingsService Service for settings
   */
  constructor(private settingsService: SettingsService) { }

  /**
   * Component initialisation method
   */
  ngOnInit(): void {
    if(!this.loading){
      this.loading = true;
      this.loadSettings().add(()=>this.loading = false);
    }
  }

  /**
   * Method used to manage errors
   * @param err Erreur
   */
  onError(err: string){
    this.error = err;
  }

  /**
   * Loading initial settings
   * @private
   */
  private loadSettings(){
    return this.settingsService.getSettings().subscribe({
      next: (res: Game) => {
        this.game.fromJSON(res);
        this.error = '';
      },
      error: (err: HttpErrorResponse) => err.error.message === undefined ? this.onError(err.name + " " + err.message) : this.onError(err.error.message)
    });
  }
}
