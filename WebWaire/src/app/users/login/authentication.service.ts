import { Injectable } from '@angular/core';
import { Login } from '../login.model';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  isLoggedIn: boolean = false;
  storeUser(user: Login){
sessionStorage.setItem("userData", JSON.stringify(user));
  }
  retrieveUser(): Login{
    var data: any = sessionStorage.getItem("userData");
    return JSON.parse(data == null?'':data);
  }
  removeUser(){
    sessionStorage.removeItem("userData");
  }
  retrieveUserType(){
    var data: any = sessionStorage.getItem("userData");
    var user: Login = JSON.parse(data == null?'':data);
    return user.role;
  }
  constructor() { }
}