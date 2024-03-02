import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {GenericService} from "./common/generic.service";

@Injectable({
  providedIn: 'root'
})
export class SettingsService {
  customUrl = '/api/settings';
  constructor(private httpClient: HttpClient, private genericService: GenericService) { }

  getSettings () {
    return this.httpClient.get(this.genericService.baseUrl + this.customUrl + '', );
  }
}
