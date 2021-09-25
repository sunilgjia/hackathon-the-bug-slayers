import { HashLocationStrategy, LocationStrategy } from '@angular/common';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {
  AppAsideModule,
  AppBreadcrumbModule, AppFooterModule, AppHeaderModule, AppSidebarModule
} from '@coreui/angular';
import { IconModule, IconSetModule, IconSetService } from '@coreui/icons-angular';
import { ChartsModule } from 'ng2-charts';
// Import 3rd party components
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { TabsModule } from 'ngx-bootstrap/tabs';
import { PerfectScrollbarModule } from 'ngx-perfect-scrollbar';
import { AppComponent } from './app.component';
// Import routing module
import { AppRoutingModule } from './app.routing';
// Import containers
import { DefaultLayoutComponent } from './containers';
import { LoginComponent } from './views/login/login.component';

const APP_CONTAINERS = [
  DefaultLayoutComponent
];

@NgModule({
  imports: [
    BrowserModule,
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
  ],
  declarations: [
    AppComponent,
    ...APP_CONTAINERS,
    LoginComponent,
  ],
  providers: [
    {
      provide: LocationStrategy,
      useClass: HashLocationStrategy
    },
    IconSetService,
  ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
