import {Component, OnInit} from '@angular/core';
import {GridComponent} from "./components/grid/grid.component";
import {ActionsComponent} from "./components/actions/actions.component";
import {SettingsService} from "./services/settings.service";
import {HttpClientModule, HttpErrorResponse} from "@angular/common/http";
import {Game} from "./models/game";
import {NgIf} from "@angular/common";

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

  title: string = 'wildfire-front';
  game: Game = new Game();
  loading = false;
  error = '';

  constructor(private settingsService: SettingsService) { }

  ngOnInit(): void {
    if(!this.loading){
      this.loading = true;
      this.loadSettings().add(()=>this.loading = false);
    }
  }

  onError(tutu: string){
    this.error = tutu;
  }

  private loadSettings(){
    return this.settingsService.getSettings().subscribe({
      next: (res: Game) => {
        this.game.fromJSON(res);
        this.error = '';
      },
      error: (err: HttpErrorResponse) => this.error = err.message
    });
  }
}
