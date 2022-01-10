import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from './authentication.service';
import { LoginService } from '../login.service';
import { Login } from '../login.model';
import { Router } from '@angular/router';
import { Role } from 'src/app/role.model';
import { HelloManagerComponent } from 'src/app/hello-manager/hello-manager.component';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  newUser:Login = new Login();
  constructor(private loginService: LoginService, private authService: AuthenticationService,
    private router:Router) {}
    ngOnInit():void {
    }
    validateLogin(){
     this.loginService.validateUserService(this.newUser).subscribe(
       (response) => {
         console.log("response after validateUser");
         console.log(response);
         this.newUser=response;
         if(this.newUser.firstName!=""){
           this.authService.storeUser(this.newUser);
           this.authService.isLoggedIn = true;
           if(this.newUser.role == 3){
               this.router.navigate(['hello-manager']);
           } else if(this.newUser.role == 2){
               this.router.navigate(['hello-employee']);
           }
         }
         }
     );
    }
  }
