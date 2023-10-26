import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {DeveloperListComponent} from './developer/developer-list/developer-list.component';
import {HttpClientModule} from "@angular/common/http";
import {ToastrModule} from "ngx-toastr";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {AppRoutingModule} from "../app-routing/app-routing.module";
import {DeveloperAddComponent} from './developer/developer-add/developer-add.component';
import {FormsModule} from "@angular/forms";
import { DeveloperDetailsComponent } from './developer/developer-details/developer-details.component';
import { GameAddComponent } from './game/game-add/game-add.component';
import { GameDetailsComponent } from './game/game-details/game-details.component';


@NgModule({
  declarations: [
    AppComponent,
    DeveloperListComponent,
    DeveloperAddComponent,
    DeveloperDetailsComponent,
    GameAddComponent,
    GameDetailsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot({
        positionClass: "toast-top-right"
      }
    ),
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
