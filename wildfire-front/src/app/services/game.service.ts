import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {GenericService} from "./common/generic.service";
import {Observable} from "rxjs";
import {Game} from "../models/game";

@Injectable({
  providedIn: 'root'
})
export class GameService {
  customUrl = '/api/game';
  constructor(private httpClient: HttpClient, private genericService: GenericService) { }

  runStep(currentGame:Game): Observable<any> {
    return this.httpClient.post(this.genericService.baseUrl + this.customUrl + '/run/step', {
      "game": currentGame
    });
  }

  checkEndGame(currentGame:Game): Observable<any> {
    let httpParams = new HttpParams().append('game', JSON.stringify(currentGame));
    return this.httpClient.get(this.genericService.baseUrl + this.customUrl + '/end', {params: httpParams});
  }
}
