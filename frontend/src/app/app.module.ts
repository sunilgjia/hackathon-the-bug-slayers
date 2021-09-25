import {
  CommonModule,
  HashLocationStrategy,
  LocationStrategy
} from "@angular/common";
import { HttpClientModule } from "@angular/common/http";
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { BrowserModule } from "@angular/platform-browser";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import {
  AppAsideModule,
  AppBreadcrumbModule,
  AppFooterModule,
  AppHeaderModule,
  AppSidebarModule
} from "@coreui/angular";
import { IconModule, IconSetModule } from "@coreui/icons-angular";
import { NgbModule } from "@ng-bootstrap/ng-bootstrap";
import { ChartsModule } from "ng2-charts";
// Import 3rd party components
import { BsDropdownModule } from "ngx-bootstrap/dropdown";
import { TabsModule } from "ngx-bootstrap/tabs";
import { PerfectScrollbarModule } from "ngx-perfect-scrollbar";
// Import routing module
import { AppRoutingModule } from "./app.routing";
import { AppComponent } from "./components";
// Import containers
import { DefaultLayoutComponent } from "./containers";
import { CredentialService, HttpService, UserService } from "./services";
import { LoginComponent } from "./views/login/login.component";
import { ToastrModule, ToastrService } from 'ngx-toastr';


const APP_CONTAINERS = [DefaultLayoutComponent];

@NgModule({
  imports: [
    CommonModule,
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    AppAsideModule,
    AppBreadcrumbModule.forRoot(),
    AppFooterModule,
    AppHeaderModule,
    AppSidebarModule,
    PerfectScrollbarModule,
    BsDropdownModule.forRoot(),
    TabsModule.forRoot(),
    ChartsModule,
    IconModule,
    IconSetModule.forRoot(),
    HttpClientModule,
    NgbModule,
    ToastrModule,
    ToastrModule.forRoot()
  ],
  declarations: [AppComponent, ...APP_CONTAINERS, LoginComponent],
  providers: [
    {
      provide: LocationStrategy,
      useClass: HashLocationStrategy,
    },
    HttpService,
    UserService,
    CredentialService,
    ToastrService
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
