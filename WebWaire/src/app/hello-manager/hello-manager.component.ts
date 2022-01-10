import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Reimbursement } from '../reimbursement/reimbursement-edit/reimbursement.model';
import { ReimbursementService } from '../reimbursement/reimbursement-edit/reimbursement.service';

@Component({
  selector: 'app-hello-manager',
  templateUrl: './hello-manager.component.html',
  styleUrls: ['./hello-manager.component.css']
})
export class HelloManagerComponent implements OnInit {

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
    console.log("after calling getAllReimbursementsService()");
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
  getAllReimbursementsService(){
    this.reimbursementService.getAllReimbursementsService().subscribe(
      (response) => {
        console.log(response);
        this.loadReimbursements();
      },
      (error) => {
        console.log(error);
      }
    )
  }
  updateReimbursement(requesterId: number){
    this.reimbursementService.updateReimbursementService(this.newReimbursement).subscribe(
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
