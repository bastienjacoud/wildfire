import {Component, Inject,OnInit, ViewChild} from '@angular/core';
import {
  MAT_DIALOG_DATA,
  MatDialogActions,
  MatDialogContent, MatDialogRef,
  MatDialogTitle
} from "@angular/material/dialog";
import {MatSlider, MatSliderThumb} from "@angular/material/slider";
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {Settings} from "../../../models/settings";
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
  appSettings : Settings | null = null;
  form = new FormGroup({
    "nbCols" : new FormControl(this.appSettings?.nbCols, Validators.required),
    "nbRows" : new FormControl(this.appSettings?.nbRows, Validators.required),
    "probability" : new FormControl(this.appSettings?.probability, Validators.required),
  });

  constructor(public dialogRef: MatDialogRef<SettingsDialogComponent>, @Inject(MAT_DIALOG_DATA) public data: Settings) {
    this.appSettings = data;
  }

  onCancel(): void {
    this.dialogRef.close();
  }

  onSave(): void {
    console.log(this.appSettings);
    console.log(this.form.value.nbCols);
  }

}
