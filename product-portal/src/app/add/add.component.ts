import { Component, ElementRef, OnInit, ViewChild , Input } from '@angular/core';
import { ProductService } from '../product.service';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, FormControl, Validators, FormArray} from '@angular/forms';
import { IDropdownSettings, } from 'ng-multiselect-dropdown'


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

  

  //Multiple select
  prod = new FormControl('');
  prodList: { [key: string]: Object }[] = [
    {item_id: 1, item_text: 'New mobile'}, 
    {item_id: 2, item_text: 'New product'}, 
    {item_id: 3, item_text: 'Amazing features'}, 
    {item_id: 4, item_text: 'New version'}, 
    {item_id: 5, item_text: 'New Themes'}, 
    {item_id: 6, item_text: 'Color'}
];




 

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
    date: any;
 
    

  constructor(
      private productService : ProductService,
      private router: Router,
      fb: FormBuilder,
      private formBuilder: FormBuilder   
      ) {
        this.toppings = fb.group({
          storage: false,
          RAM: false,
          camera: false,
        });
    }



   
 
  ngOnInit(): void {}
  


//quantity
quantity:number= 1;
  
plus()
{
 this.quantity = this.quantity+1;
}
minus()
{
  if(this.quantity != 0)
{
 this.quantity = this.quantity-1;
}

}


  //createNewProduct
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


  //dropdown
  selected = '';
  price: Price[] = [
    {value: '15000-20000', viewValue: '15000-20000'},
    {value: '20000-30000', viewValue: '20000-30000'},
    {value: '30000-50000', viewValue: '30000-50000'},
  ];
  
}









  

