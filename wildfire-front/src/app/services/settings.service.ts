import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {GenericService} from "./common/generic.service";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class SettingsService {
  customUrl = '/api/settings';
  constructor(private httpClient: HttpClient, private genericService: GenericService) { }

  getSettings (): Observable<any> {
    return this.httpClient.get(this.genericService.baseUrl + this.customUrl + '', );
  }
}
