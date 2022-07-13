import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import { ProductService } from '../product.service';
import { MatTable } from '@angular/material/table';
import { MatSort, Sort } from '@angular/material/sort';
import { SelectorMatcher } from '@angular/compiler';
import { MatTableDataSource } from '@angular/material/table';
import { LiveAnnouncer} from '@angular/cdk/a11y';
import { MatPaginator, MatPaginatorModule} from '@angular/material/paginator';
import { SelectionModel } from '@angular/cdk/collections';  
import { Data } from '@angular/router';
import { row } from '@syncfusion/ej2-angular-grids';
import { Router, ActivatedRoute } from '@angular/router';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { DialogBoxComponent } from '../dialog-box/dialog-box.component';

@Component({ 
  selector: 'product.component',
  templateUrl: 'product.component.html' ,
  styleUrls: ['./product.component.css']
})


export class ProductComponent implements OnInit{
  search : String ="";

  productName:  any;
  productType: any;
  productDescription: any;
  productQuantity: any;
  productPrice: any;
  productId: any;
  productsList: any;
  Productmul: any;
  upload: any;
  check: any;
  displayedColumns: string[] = ['checked', 'productId', 'productName', 'productType', 'productDesc', 'productQuantity', 'productPrice','action'];
  dataSource : any;
  rows: any;
  opened = false;
  selection = new SelectionModel < Data > (true, []); 
  router: any;
  action: any;
  key: any;
  date: any;

  /** Whether the number of selected elements matches the total number of rows. */  
isAllSelected() {  
  const numSelected = this.selection.selected.length;  
  const numRows = !!this.dataSource && this.dataSource.data.length;  
  return numSelected === numRows;  
}  
/** Selects all rows if they are not all selected; otherwise clear selection. */
masterToggle() {
  this.isAllSelected() ?
      this.selection.clear() :
      this.dataSource.data.forEach((row: Data) => this.selection.select(row));
}


  @ViewChild(MatSort) sort: any;
  @ViewChild(MatPaginator) paginator: any;
  @ViewChild(MatTable,{static:true}) table: any;

  private _liveAnnouncer: any;

  constructor(private productService : ProductService , _liveAnnouncer: LiveAnnouncer, private dialog: MatDialog) {}

  openDialog(){
    this.dialog.open(DialogBoxComponent,{
      width: '30%',
    }).afterClosed().subscribe(data=>{
        if(data ==='save'){
          console.log("success");
      this.getProductList()
        }
    });
  }
  
  editProduct(row: any){
    this.dialog.open(DialogBoxComponent,{
      width: '30%',
      data: row
    }).afterClosed().subscribe(data => {
      if(data ==='save'){
      console.log("success");
      this.getProductList()}
    });
  }
 


 //get products
  ngOnInit(){ 
    this.getProductList()
  }
  getProductList(){
    this.productService.findAll().subscribe(data => {
      this.rows = data;
      console.log(this.productsList);
      this.dataSource =  new MatTableDataSource(data)
      this.dataSource.sort = this.sort;
      this.dataSource.paginator = this.paginator;
    }); 
  }

  //add products
  createProduct(){
    let newProduct = [{
      productId: this.productId,
      productName: this.productName,
      productType: this.productType,
      productDesc: this.productDescription,
      productQuantity: this.productQuantity,
      productPrice: this.productPrice,
      Productmul: this.Productmul,
      upload: this.upload,
      check: this.check
    }]

    this.productService.save(newProduct).subscribe(data => {
      console.log("success");
      this.getProductList()
    });
  }

//delete
 
// reloadData(){
  
// }
// deleteProduct(productId: number) { 
//   this.productService.delete(productId).subscribe(data => { 
//     console.log("success");
//     this.reloadData();
//   })
  
//   }

  //delete
  deleteProduct() { 
  const numSelected = this.selection.selected;  
  console.log(numSelected[0]['productId'])
  if (numSelected.length > 0) {  
      let productIds = []
          for(let i =0;i<numSelected.length;i++){
            productIds.push({"productId":numSelected[i]['productId']})
          }
          this.productService.delete(productIds).subscribe(data => {  
               
            this.getProductList()
        })
      }  
  
} 
               
    
 
  ngAfterViewInit() {}

  //sorting
  announceSortChange(sortState: Sort) {
    
    if (sortState.direction) {
      this._liveAnnouncer.announce('Sorted ${sortState.direction}ending');
    } else {
      this._liveAnnouncer.announce('Sorting cleared');
    }
  }
  applyFilter(filterValue: string) {
    filterValue = filterValue.trim();
    filterValue = filterValue.toLowerCase();
    this.dataSource.filter = filterValue;
  }
}
function result(result: any) {
  throw new Error('Function not implemented.');
}



