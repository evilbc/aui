import {NgModule} from '@angular/core';
import {DeveloperListComponent} from "../app/developer/developer-list/developer-list.component";
import {RouterModule, Routes} from "@angular/router";
import {DeveloperAddComponent} from "../app/developer/developer-add/developer-add.component";
import {DeveloperDetailsComponent} from "../app/developer/developer-details/developer-details.component";
import {GameAddComponent} from "../app/game/game-add/game-add.component";
import {GameDetailsComponent} from "../app/game/game-details/game-details.component";


const routes: Routes = [
  {path: '', redirectTo: '/developers/list', pathMatch: 'full'},
  {path: 'developers/list', component: DeveloperListComponent},
  {path: 'developers/add', component: DeveloperAddComponent},
  {path: 'developers/:id/edit', component: DeveloperAddComponent},
  {path: 'developers/:id', component: DeveloperDetailsComponent},
  {path: 'developers/:id/games/add', component: GameAddComponent},
  {path: 'developers/:id/games/:gameId/edit', component: GameAddComponent},
  {path: 'developers/:id/games/:gameId', component: GameDetailsComponent},
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
