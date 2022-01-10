import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './users/login/login.component';
import { HeaderComponent } from './header/header.component';
import { ReimbursementEditComponent } from './reimbursement/reimbursement-edit/reimbursement-edit.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { HelloEmployeeComponent } from './hello-employee/hello-employee.component';
import { HelloManagerComponent } from './hello-manager/hello-manager.component';
import { ReimbursementComponent } from './reimbursement/reimbursement.component';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HeaderComponent,
    ReimbursementEditComponent,
    HelloEmployeeComponent,
    HelloManagerComponent,
    ReimbursementComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
