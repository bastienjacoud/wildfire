import {Component, NgModule, OnInit} from '@angular/core';
import {TreeStatus} from "./models/enums/tree-status";
import {GridComponent} from "./components/grid/grid.component";
import {ActionsComponent} from "./components/actions/actions.component";
import {Tree} from "./models/tree";
import {SettingsService} from "./services/settings.service";
import {HttpClientModule} from "@angular/common/http";


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
  treeList: Tree[] = [
    {
      status : TreeStatus.NORMAL,
      posX : 0,
      posY : 0
    },
    {
      status : TreeStatus.NORMAL,
      posX : 1,
      posY : 0
    },
    {
      status : TreeStatus.NORMAL,
      posX : 2,
      posY : 0
    },
    {
      status : TreeStatus.NORMAL,
      posX : 0,
      posY : 1
    },
    {
      status : TreeStatus.NORMAL,
      posX : 1,
      posY : 1
    },
    {
      status : TreeStatus.NORMAL,
      posX : 2,
      posY : 1
    },
    {
      status : TreeStatus.NORMAL,
      posX : 0,
      posY : 2
    },
    {
      status : TreeStatus.FIRE,
      posX : 1,
      posY : 2
    },
    {
      status : TreeStatus.CINDER,
      posX : 2,
      posY : 2
    }
  ];
  nbColumns: number = 3;
  loading = false;
  error = '';
  constructor(private settingsService: SettingsService) { }

  ngOnInit(): void {
    this.getSettings();
  }

  getSettings(){
    if(!this.loading){
      this.loading = true;
      this.settingsService.getSettings().subscribe({
        next: (settings : any) => console.log(settings),
        error: (err) => console.log(err)
      });
    }
  }
}
