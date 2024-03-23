import {Component, Inject, Input, OnInit, ViewChild} from '@angular/core';
import {
  MAT_DIALOG_DATA,
  MatDialogActions,
  MatDialogContent, MatDialogRef,
  MatDialogTitle
} from "@angular/material/dialog";
import {MatSlider, MatSliderThumb} from "@angular/material/slider";
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {Game} from "../../../models/game";
import {MatButton} from "@angular/material/button";

@Component({
  selector: 'app-settings-dialog',
  standalone: true,
  imports: [
    MatDialogActions,
    MatSlider,
    MatSliderThumb,
    ReactiveFormsModule,
    MatButton,
    MatDialogContent,
    MatDialogTitle
  ],
  templateUrl: './settings-dialog.component.html',
  styleUrl: './settings-dialog.component.css'
})
export class SettingsDialogComponent {
  @Input() game !: Game;
  form = new FormGroup({
    "nbCols" : new FormControl(this.game.nbCols, Validators.required),
    // "nbRows" : new FormControl(this.game.nbRows, Validators.required),
    "probability" : new FormControl(this.game?.probability, Validators.required),
  });

  constructor(public dialogRef: MatDialogRef<SettingsDialogComponent>, @Inject(MAT_DIALOG_DATA) public data: Game) {
    this.game = data;
  }

  onCancel(): void {
    this.dialogRef.close();
  }

  onSave(): void {
    //TODO
    console.log(this.game);
    console.log(this.form.value.nbCols);
  }

}
