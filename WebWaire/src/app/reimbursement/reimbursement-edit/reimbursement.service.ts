import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Reimbursement } from './reimbursement.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReimbursementService {
  baseUrl = "http://localhost:4040/api/reimbursement";
  constructor(private http: HttpClient) { }
  getAllReimbursementsService(): Observable<Reimbursement[]>{
    //need to consume the get end point "http://localhost:3000/reimbursement"
     // specify the return type as Observable with the generic type
     // also specify the generic type near the get function because we
         //cannot have different generic types
         return this.http.get<Reimbursement[]>(this.baseUrl);
 }
 addReimbursementService(newReimbursement: Reimbursement): Observable<Reimbursement>{
   return this.http.post<Reimbursement>(this.baseUrl, newReimbursement);
 }
 getEmployeePendingReimbursementsService(requester: number): Observable<Reimbursement>{
   return this.http.get<Reimbursement>(this.baseUrl+"/"+requester);
 }
 getEmployeeResolvedReimbursementsService(requester: number): Observable<Reimbursement>{
   return this.http.get<Reimbursement>(this.baseUrl+"/"+requester);
 }
 updateReimbursementService(updateReimbursement: Reimbursement): Observable<Reimbursement>{
   return this.http.put<Reimbursement>(this.baseUrl+"/"+updateReimbursement.reimbursementId, updateReimbursement);
 }
 viewAllPendingReimbursementService(author: number): Observable<Reimbursement>{
   return this.http.get<Reimbursement>(this.baseUrl);
 }
 viewAllResolvedReimbursementService(author: number): Observable<Reimbursement>{
   return this.http.get<Reimbursement>(this.baseUrl);
 }
 }