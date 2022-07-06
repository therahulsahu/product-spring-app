import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ProductService {
  deleteData(numSelected: import("@angular/router").Data[]) {
    throw new Error('Method not implemented.');
  }
  private apiUrl: string;



  constructor(private http: HttpClient) { 
    this.apiUrl = 'http://localhost:8080/api/productlist/v1'
  }
  public findAll():Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/getlist`);
  }
  
  
  public save(product: any) {
    return this.http.post<any>(`${this.apiUrl}/createproduct`, product);
  }

  
  
  public login(user: any) {
    return this.http.post<any>(`${this.apiUrl}/login`, user);
  }


  public delete(productId: any) {
    return this.http.post<any>(`${this.apiUrl}/deleteproduct`, productId);
  }
  

 
}