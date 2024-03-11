import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {GenericService} from "./common/generic.service";
import {Grid} from "../models/grid";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class GameService {
  customUrl = '/api/game';
  constructor(private httpClient: HttpClient, private genericService: GenericService) { }

  runStep(currentGrid:Grid): Observable<any> {
    return this.httpClient.post(this.genericService.baseUrl + this.customUrl + '/run/step', {
      "grid": currentGrid
    });
  }
}
