import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { ChartsModule } from "ng2-charts";
import { ButtonsModule } from "ngx-bootstrap/buttons";
import { BsDropdownModule } from "ngx-bootstrap/dropdown";
import { TabsModule } from "ngx-bootstrap/tabs";
import { ToastrService } from "ngx-toastr";
import {
  AddEditCredentialComponent,
  CredentialListComponent,
} from "./components";
import { LoaderComponent } from "./components/loader/loader.component";
import { CredentialRoutingModule } from "./credential-routing.module";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    CredentialRoutingModule,
    ChartsModule,
    TabsModule,
    BsDropdownModule,
    ButtonsModule.forRoot(),
  ],
  declarations: [
    CredentialListComponent,
    AddEditCredentialComponent,
    LoaderComponent,
  ],
  entryComponents: [AddEditCredentialComponent],
  providers: [
    ToastrService
  ]
})
export class CredentialModule {}
