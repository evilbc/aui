import {NgModule} from '@angular/core';
import {DeveloperListComponent} from "../app/developer/developer-list/developer-list.component";
import {RouterModule, Routes} from "@angular/router";
import {DeveloperAddComponent} from "../app/developer/developer-add/developer-add.component";


const routes: Routes = [
  {path: '', redirectTo: '/developer-list', pathMatch: 'full'},
  {path: 'developer-list', component: DeveloperListComponent},
  {path: 'developer-add', component: DeveloperAddComponent}

];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
