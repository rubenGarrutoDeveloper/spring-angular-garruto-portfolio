import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { BaseApiService } from './base-api.service';

export interface Hello {
  id: number;
  value: string;
}

@Injectable({
  providedIn: 'root'
})
export class HelloService extends BaseApiService<Hello> {


    constructor(http: HttpClient) {
    // Call parent constructor with endpoint name
    // This sets up the full URL: baseUrl + '/personal-info'
    super(http, 'hello');
  }

  getHello(): Observable<Hello[]> {
    return this.getAll();
  }
}
