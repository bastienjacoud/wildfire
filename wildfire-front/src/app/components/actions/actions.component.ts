import {Component, OnInit} from '@angular/core';
import {MatFabButton} from "@angular/material/button";
import {MatIcon} from "@angular/material/icon";
import {SettingsDialogComponent} from "./settings-dialog/settings-dialog.component";
import {MatDialog} from "@angular/material/dialog";

@Component({
  selector: 'app-actions',
  standalone: true,
    imports: [
        MatFabButton,
        MatIcon
    ],
  templateUrl: './actions.component.html',
  styleUrl: './actions.component.css'
})
export class ActionsComponent implements OnInit{
  constructor(public dialog: MatDialog) {}
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

  nextStep() {
    //TODO
  }

}
