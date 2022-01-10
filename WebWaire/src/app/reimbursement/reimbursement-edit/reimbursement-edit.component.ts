import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Reimbursement } from './reimbursement.model';
import { ReimbursementService } from './reimbursement.service';


@Component({
  selector: 'app-reimbursement-edit',
  templateUrl: './reimbursement-edit.component.html',
  styleUrls: ['./reimbursement-edit.component.css']
})
export class ReimbursementEditComponent implements OnInit {
  updateReimbursement: Reimbursement = {
    reimbursementId: 0,
    requesterId: 0,
    resolverId: 0,
    reimbursementAmount: 0,
    date: 0,
    Certification: "",
    status: "",
  }
  constructor(private reimbursementService: ReimbursementService,
    private activatedRoute: ActivatedRoute,
    private router: Router) { }
  ngOnInit(): void {var receivedReimbursementId: any = this.activatedRoute.snapshot.paramMap.get("sentReimbursementId");
  console.log(receivedReimbursementId);
  this.reimbursementService.updateReimbursementService(receivedReimbursementId).subscribe(
    (response) => {
      this.updateReimbursement = response;
    },
    (error)=> {
      console.log(error);
    }
  );
}
  editReimbursement(){
    this.reimbursementService.updateReimbursementService(this.updateReimbursement).subscribe(
      (response) => {
        console.log(response);
        this.router.navigate(['reimbursement-info']);
      },
      (error) => {
        console.log(error);
      }
      );
  }
  logDescriptionChange(rDescription: any){
    console.log("Description template variable:");
    console.log(rDescription);
  }
}