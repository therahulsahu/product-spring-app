import { Component, ElementRef, OnInit, ViewChild, Input } from '@angular/core';
import { ProductService } from '../product.service';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, FormControl, Validators, FormArray } from '@angular/forms';



interface Price {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']

})
export class AddComponent implements OnInit {
  toppings: FormGroup;
  title = 'angular-key-press-example';


  invalidCredentials: boolean = false;
  ProductForm !: FormGroup;
  productId: any;
  productName: any;
  productDesc: any;
  productPrice: any;
  productQuantity: any;
  productType: any;
  Productmul: any;
  upload: any;
  check: any;
  checkbox: any;
  date: any;
  prod = new FormControl('');
  prodList: string[] = ['New mobile', 'New product', 'Amazing features', 'New version', 'New Themes', 'Color'];


  constructor(
    private productService: ProductService,
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

  ngOnInit(): void { }

  radio = ["Laptop", "Mobile", "Tablet"]

  //quantity
  quantity: number = 1;
  plus() {
    this.quantity = this.quantity + 1;
  }
  minus() {
    if (this.quantity != 0) {
      this.quantity = this.quantity - 1;
    }
  }


  //createNewProduct
  createProduct() {
    let newProduct = [{
      productId: this.productId,
      productName: this.productName,
      productDesc: this.productDesc,
      productPrice: this.productPrice,
      productQuantity: this.productQuantity,
      productType: this.productType,
    }]
    this.productService.save(newProduct).subscribe(data => {
      console.log("success");
      this.router.navigate(['/product']);
    });
  }
}
