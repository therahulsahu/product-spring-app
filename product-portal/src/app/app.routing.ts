import { Routes, RouterModule } from '@angular/router';

import { ProductComponent } from './product';
import { AddComponent } from './add';
import { LoginComponent } from './login';
import { ProductWrapperComponent } from './product-wrapper/product-wrapper.component';

const routes: Routes = [
    
    { path: '', component: LoginComponent },
    { path: 'product', component: ProductComponent },
    { path: 'add', component: AddComponent },
    { path: 'logout', component: LoginComponent},
    { path: 'dashboard', component: ProductWrapperComponent},

    // otherwise redirect to home
    { path: '**', redirectTo: '' }
];

export const appRoutingModule = RouterModule.forRoot(routes);