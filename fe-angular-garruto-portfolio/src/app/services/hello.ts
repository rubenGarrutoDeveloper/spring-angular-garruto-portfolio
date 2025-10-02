import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Hello {
  id: number;
  value: string;
}

@Injectable({
  providedIn: 'root'
})
export class HelloService {
  private apiUrl = 'https://spring-angular-garruto-portfolio.onrender.com/api/v1/hello';

  constructor(private http: HttpClient) { }

  getHello(): Observable<Hello[]> {
    return this.http.get<Hello[]>(this.apiUrl);
  }
}
