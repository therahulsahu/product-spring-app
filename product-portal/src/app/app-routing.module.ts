import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductComponent } from './product';
import { AddComponent } from './add';
import { LoginComponent } from './login';

import { ProductWrapperComponent } from './product-wrapper/product-wrapper.component';

const routes: Routes = [
    { path: '', component: LoginComponent },
    { path: 'product', component: ProductComponent },
    { path: 'add', component: AddComponent },
    { path: 'dashboard', component: ProductWrapperComponent },

    // otherwise redirect to home
    { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
