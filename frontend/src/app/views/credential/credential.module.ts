import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ChartsModule } from 'ng2-charts';
import { ButtonsModule } from 'ngx-bootstrap/buttons';
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { CredentialListComponent } from './components';
import { CredentialRoutingModule } from './credential-routing.module';


@NgModule({
  imports: [
    FormsModule,
    CredentialRoutingModule,
    ChartsModule,
    BsDropdownModule,
    ButtonsModule.forRoot()
  ],
  declarations: [ CredentialListComponent ]
})
export class CredentialModule { }
