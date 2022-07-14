import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'My newlist';
  

  
  constructor(private router: Router){

  }
  ngOnInit(): void {
      
  }
  add(){
    this.router.navigate(['add']);
  }
  product(){
    this.router.navigate(['product']);
  }
  login(){
    this.router.navigate(['login']);
  }
  report(){
    this.router.navigate(['report']);
  }
 


}
