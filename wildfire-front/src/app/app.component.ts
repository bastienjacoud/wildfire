import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {GridComponent} from "./components/grid/grid.component";
import {ActionsComponent} from "./components/actions/actions.component";
import {SettingsService} from "./services/settings.service";
import {HttpClientModule} from "@angular/common/http";
import {Settings} from "./models/settings";


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
  settings: Settings = new Settings();
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
      next: (settings : any) => this.settings.fromJSON(settings),
      error: (err) => this.error=err
    });
  }
}
