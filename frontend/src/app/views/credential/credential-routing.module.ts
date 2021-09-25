import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CredentialListComponent } from './components';

const routes: Routes = [
  {
    path: '',
    component: CredentialListComponent,
    data: {
      title: 'Credentials'
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CredentialRoutingModule {}
