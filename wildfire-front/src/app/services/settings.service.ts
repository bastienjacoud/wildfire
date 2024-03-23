import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {GenericService} from "./common/generic.service";
import {Observable} from "rxjs";

/**
 * Service for settings
 */
@Injectable({
  providedIn: 'root'
})
export class SettingsService {

  /**
   * URL
   */
  customUrl = '/api/settings';

  /**
   * Constructor
   * @param httpClient Httpclient
   * @param genericService Generic service
   */
  constructor(private httpClient: HttpClient, private genericService: GenericService) { }

  /**
   * Get method for settings
   */
  getSettings (): Observable<any> {
    return this.httpClient.get(this.genericService.baseUrl + this.customUrl + '');
  }
}
