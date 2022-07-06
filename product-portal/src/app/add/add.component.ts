import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ProductService } from '../product.service';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, FormControl, Validators, FormArray} from '@angular/forms';


// import {NgbDateStruct, NgbCalendar} from '@ng-bootstrap/ng-bootstrap';


interface Price {
  value: string;
  viewValue: string;
}

@Component({ 
    selector: 'add',
    templateUrl: './add.component.html' ,
    styleUrls: ['./add.component.css']

})
export class AddComponent implements OnInit{
  toppings: FormGroup;
  // checked = false;
  // indeterminate = false;
  // labelPosition: 'before' | 'after' = 'after';
  // disabled = false;
  title = 'angular-key-press-example';
  // Only Integer Numbers
  keyPressNumbers(event: any) {
    var charCode = (event.which) ? event.which : event.keyCode;
    // Only Numbers 0-9
    if ((charCode < 48 || charCode > 57)) {
      event.preventDefault();
      return false;
    } else {
      return true;
    }
  }


  cars = [
    { id: 1, name: "new mobile" },
    { id: 2, name: "New product" },
    { id: 3, name: "Amazing features" },
    { id: 4, name: "new version" },
    { id: 5, name: "New themes" },
  ];
  select = [{ id: 3, name: "Amazing features" }];


    productId: any;
    productName:  any;
    productDesc: any;
    productPrice: any;
    productQuantity: any;
    productType: any;
    Productmul: any;
    upload: any;
    check: any;
    checkbox: any;
 
    

  constructor(
      private productService : ProductService,
      private router: Router,
      fb: FormBuilder
      ) {
        this.toppings = fb.group({
          pepperoni: false,
          extracheese: false,
          mushroom: false,
        });
    }
   
 

  ngOnInit(): void {
  }
  // createNewProduct
  createProduct(){
    let newProduct = [{
      productId: this.productId,
      productName: this.productName,
      productDesc: this.productDesc,
      productPrice: this.productPrice,
      productQuantity: this.productQuantity,
      productType: this.productType,
      // upload: this.upload,
      // toppings: this.toppings,
      // check: this.check
    }]
   
   
    this.productService.save(newProduct).subscribe(data => {
      console.log("success");
    });
    this.router.navigate(['/product']); 
    
  }
  selected = '';
  price: Price[] = [
    {value: '15000-20000', viewValue: '15000-20000'},
    {value: '20000-30000', viewValue: '20000-30000'},
    {value: '30000-50000', viewValue: '30000-50000'},
  ];
  
}









  

