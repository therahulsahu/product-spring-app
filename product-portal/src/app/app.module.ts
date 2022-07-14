import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductComponent } from './product';
import { AddComponent } from './add';
import { LoginComponent } from './login';
import { FormsModule } from '@angular/forms';
import { ProductWrapperComponent } from './product-wrapper/product-wrapper.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { NgxPaginationModule } from 'ngx-pagination';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { Ng2OrderModule } from 'ng2-order-pipe';
import { ReactiveFormsModule } from '@angular/forms';
import { MatIconModule } from '@angular/material/icon';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatSortModule } from '@angular/material/sort';
import { GridModule } from '@syncfusion/ej2-angular-grids';
import { SortService } from '@syncfusion/ej2-angular-grids';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatToolbarModule } from '@angular/material/toolbar';
import {MatCheckboxModule} from '@angular/material/checkbox';
import { MatRadioModule} from '@angular/material/radio';
import { MatSelectModule } from '@angular/material/select';
import { CommonModule } from '@angular/common';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatProgressBarModule } from '@angular/material/progress-bar';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { NgSelectModule } from "@ng-select/ng-select";
import { MatNativeDateModule } from '@angular/material/core';
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';
import { ReportComponent } from './report/report.component';
import { DialogBoxComponent } from './dialog-box/dialog-box.component';
import { MatDialogModule } from '@angular/material/dialog';


@NgModule({
  declarations: [
    AppComponent,
    ProductComponent,
    AddComponent,
    LoginComponent,
    ProductWrapperComponent,
    ReportComponent,
    DialogBoxComponent,


  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    FlexLayoutModule,
    MatCardModule,
    MatButtonModule,
    MatInputModule,
    ReactiveFormsModule,
    MatIconModule,
    NgxPaginationModule,
    BrowserAnimationsModule,
    MatSidenavModule,
    MatSortModule,
    Ng2SearchPipeModule,
    Ng2OrderModule,
    GridModule,
    MatTableModule,
    MatPaginatorModule,
    MatToolbarModule,
    MatCheckboxModule,
    MatRadioModule,
    MatSelectModule,
    CommonModule,
    MatFormFieldModule,
    MatProgressBarModule,
    MatDatepickerModule,
    NgSelectModule,
    MatNativeDateModule,
    MatDialogModule,

    

 
  ],
  providers: [ SortService ],
  bootstrap: [AppComponent],
  
})
export class AppModule { }
