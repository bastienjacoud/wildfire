import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class GenericService {
  public baseUrl = 'http://localhost:8080';
  constructor() { }
}
