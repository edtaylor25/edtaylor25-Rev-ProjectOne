import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Reimbursement } from './reimbursement-edit/reimbursement.model';
import { ReimbursementService } from './reimbursement-edit/reimbursement.service';


@Component({
  selector: 'app-reimbursement',
  templateUrl: './reimbursement.component.html',
  styleUrls: ['./reimbursement.component.css']
})
export class ReimbursementComponent implements OnInit {

  flag: boolean = false;
  allReimbursements: Reimbursement[] = [];
  newReimbursement: Reimbursement = {
    reimbursementId: 0,
    requesterId: 0,
    reimbursementAmount: 0,
    date: 0,
    Certification: "",
    resolverId: 0,
    status: "Pending"
  }
  constructor(private reimbursementService: ReimbursementService, private router: Router) {
   }
  ngOnInit(): void {
    this.loadReimbursements();
    console.log("after calling getAllReimbursementService()");
  }
  loadReimbursements(){
    this.reimbursementService.getAllReimbursementsService().subscribe(
      (response)=> {
        console.log(response);
        this.allReimbursements = response;
      },
      (error)=>{
        console.log(error);
      }
    );
  }
  toggleAdd(){
    if(this.flag){
      this.flag = false;
    }else{
      this.flag = true;
    }
  }
  addReimbursement(){
    this.reimbursementService.addReimbursementService(this.newReimbursement).subscribe(
      (response) => {
        console.log(response);
        this.loadReimbursements();
      },
      (error) => {
        console.log(error);
      }
    )
  }
  getEmployeePendingReimbursements(requesterId: number){
    this.reimbursementService.getEmployeePendingReimbursementsService(requesterId).subscribe(
      (response) => {
        console.log(response);
        this.loadReimbursements();
      },
      (error) => {
        console.log(error);
      }
    )
  }
  getEmployeeResolvedReimbursements(resolverId: number){
    this.reimbursementService.getEmployeeResolvedReimbursementsService(resolverId).subscribe(
      (response) => {
        console.log(response);
        this.loadReimbursements();
      },
      (error) => {
        console.log(error);
      }
    )
  }
}