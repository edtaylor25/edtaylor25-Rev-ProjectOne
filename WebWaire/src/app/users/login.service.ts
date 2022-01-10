import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Login} from '../users/login.model'

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  baseUrl = "http://localhost:4040/api/user";
  constructor(private http: HttpClient) { }
  registerUserService(newUser: Login): Observable<Login>{
    return this.http.post<Login>(this.baseUrl, newUser);
  }
  validateUserService(validateLogin: Login): Observable<Login>{
    return this.http.post<Login>(this.baseUrl+"/validate", validateLogin);
  }
  getallUsersService(): Observable<Login[]>{
    return this.http.get<Login[]>(this.baseUrl);
  }
}