import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ProductService } from '../product.service';
import { FormGroup, FormControl, Validators} from '@angular/forms';



@Component({ 
    selector: 'app-login',
    templateUrl: 'login.component.html' ,
  
})
export class LoginComponent implements OnInit{

    userName:  any;
    userPassword: any;
    invalidCredentials: boolean =  false;
    

  constructor(

    private route: ActivatedRoute,
    private router: Router,
    private productService: ProductService) {   }

  ngOnInit() {
     
      
   
  }

  handleLogin() {
      let user = {
          userName : this.userName,
          userPassword : this.userPassword
      }
   
    this.productService.login(user).subscribe(
        (data:any) => {
       
        if(data.errorCode === '200'){
           
            this.router.navigate(['dashboard']);
          }
          else{
            this.invalidCredentials = true;
          }  
        
           
        });
    
    }
      
    
      
  

}

     