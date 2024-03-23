import { Injectable } from '@angular/core';

/**
 * Generic service, used in all services
 */
@Injectable({
  providedIn: 'root'
})
export class GenericService {

  /**
   * Base URL
   */
  public baseUrl = 'http://localhost:8080';

  /**
   * Constructor
   */
  constructor() { }
}
