import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {GenericService} from "./common/generic.service";
import {Observable} from "rxjs";
import {Game} from "../models/game";

/**
 * Service for game
 */
@Injectable({
  providedIn: 'root'
})
export class GameService {

  /**
   * URL
   */
  customUrl = '/api/game';

  /**
   * Constructor
   * @param httpClient Httpclient
   * @param genericService Generic service
   */
  constructor(private httpClient: HttpClient, private genericService: GenericService) { }

  /**
   * Post method to run one step
   * @param currentGame Current game
   */
  runStep(currentGame:Game): Observable<any> {
    return this.httpClient.post(this.genericService.baseUrl + this.customUrl + '/run/step', {
      "game": currentGame
    });
  }

  /**
   * Get method to check if game is ended
   * @param currentGame Current game
   */
  checkEndGame(currentGame:Game): Observable<any> {
    let httpParams = new HttpParams().append('game', JSON.stringify(currentGame));
    return this.httpClient.get(this.genericService.baseUrl + this.customUrl + '/end', {params: httpParams});
  }
}
