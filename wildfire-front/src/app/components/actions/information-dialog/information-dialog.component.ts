import { Component } from '@angular/core';
import {MatDialogModule} from "@angular/material/dialog";
import {MatButtonModule} from "@angular/material/button";

@Component({
  selector: 'app-information-dialog',
  standalone: true,
  imports: [
    MatDialogModule,
    MatButtonModule
  ],
  templateUrl: './information-dialog.component.html',
  styleUrl: './information-dialog.component.css'
})
export class InformationDialogComponent {
  constructor() {}
}
