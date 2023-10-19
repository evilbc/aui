import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {DeveloperListComponent} from './developer/developer-list/developer-list.component';
import {HttpClientModule} from "@angular/common/http";
import {ToastNoAnimationModule, ToastrModule} from "ngx-toastr";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {RouterLink, RouterOutlet} from "@angular/router";
import {AppRoutingModule} from "../app-routing/app-routing.module";
import { DeveloperAddComponent } from './developer/developer-add/developer-add.component';


@NgModule({
  declarations: [
    AppComponent,
    DeveloperListComponent,
    DeveloperAddComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot({
        positionClass: "toast-top-right"
      }
    ),
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
