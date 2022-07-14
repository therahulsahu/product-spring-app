import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
// import { saveAs } from 'file-saver';


@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {
  router: any;

  constructor(private productService : ProductService) { }

  

     

  ngOnInit(): void {
  }
  selectedGroup: any;
  getVal() {
    console.log(this.selectedGroup); // returns selected object
    if(this.selectedGroup===1){
      this.productService.getValByPDF().subscribe((response: any) => {
        const blob = new Blob([response], { type: 'string' });
        const url= window.URL.createObjectURL(blob);     
        const link = document.createElement('a');
        document.body.appendChild(link);
        link.href = url;
        link.download="report.pdf";
        link.click(); 
      });
    } 
    else if(this.selectedGroup===2){
      this.productService.getValByExcel().subscribe((response: any) => {
        const blob = new Blob([response], { type: 'string' });
        const url= window.URL.createObjectURL(blob);     
        const link = document.createElement('a');
        document.body.appendChild(link);
        link.href = url;
        link.download="report.xlsx";
        link.click(); 
      });

    }
    else{
      this.productService.getValByCSV().subscribe((response: any) => {
        const blob = new Blob([response], { type: 'string' });
        const url= window.URL.createObjectURL(blob);     
        const link = document.createElement('a');
        document.body.appendChild(link);
        link.href = url;
        link.download="report.csv";
        link.click(); 
      });

    }

}

  groups = [{
      "id": 1,
      "name": "Download PDF",
      "items": "pdf"
  },
  {
      "id": 2,
      "name": "Download Excel",
      "items": "excel"
  },
  {
      "id": 3,
      "name": "Download CSV",
      "items": "csv"
  }];


  // downloadFile(filename: string): void {
  //   this.productService
  //     .download(filename)
  //     .subscribe(blob => saveAs(blob, filename));
  // }
}
