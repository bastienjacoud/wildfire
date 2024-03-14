import {Component, OnInit} from '@angular/core';
import {GridComponent} from "./components/grid/grid.component";
import {ActionsComponent} from "./components/actions/actions.component";
import {SettingsService} from "./services/settings.service";
import {HttpClientModule} from "@angular/common/http";
import {Game} from "./models/game";


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    GridComponent,
    ActionsComponent,
    HttpClientModule
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

  private loadSettings(){
    return this.settingsService.getSettings().subscribe({
      next: (res: Game) => this.game.fromJSON(res),
      error: (err) => this.error=err
    });
  }
}
