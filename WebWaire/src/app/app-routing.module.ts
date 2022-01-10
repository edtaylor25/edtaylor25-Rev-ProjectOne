import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './users/login/login.component';
import { HeaderComponent } from './header/header.component';
import { ReimbursementEditComponent } from './reimbursement/reimbursement-edit/reimbursement-edit.component';
import { AuthenticationGuard } from './users/login/authentication.guard';
import { HelloEmployeeComponent } from './hello-employee/hello-employee.component';
import { HelloManagerComponent } from './hello-manager/hello-manager.component';
import { ReimbursementComponent } from './reimbursement/reimbursement.component';


const routes: Routes = [
  {path:'login', component: LoginComponent},
  {path:'header', component: HeaderComponent},
  {path: 'reimbursement', component: ReimbursementComponent},
  {path: 'reimbursement', component: ReimbursementEditComponent},
  {path: 'hello-employee', component: HelloEmployeeComponent},
  {path: 'hello-manager', component: HelloManagerComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)   ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
