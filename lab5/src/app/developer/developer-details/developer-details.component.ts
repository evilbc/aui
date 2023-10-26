import {Component, OnInit} from '@angular/core';
import {Developer} from "../model/developer-model";
import {DeveloperService} from "../service/developer.service";
import {ActivatedRoute, Route} from "@angular/router";
import {GameService} from "../../game/service/game.service";
import {Game} from "../../game/model/game-model";
import {map, tap} from "rxjs/operators";

@Component({
  selector: 'app-developer-details',
  templateUrl: './developer-details.component.html',
  styleUrls: ['./developer-details.component.css']
})
export class DeveloperDetailsComponent implements OnInit {
  developer: Developer | undefined;
  games: Game[] = [];

  constructor(private developerService: DeveloperService, private route: ActivatedRoute, private gameService: GameService) {
  }

  ngOnInit(): void {
    const id: string = this.route.snapshot.paramMap.get('id')!;
    this.developerService.get(id)
      .pipe(tap(d => this.gameService.getDeveloperGames(d.id).subscribe(g => this.games = g)))
      .subscribe(d => this.developer = d);
  }

  deleteGame(game: Game): void {
    this.gameService.delete(game).pipe(map(_ => {
      if (!this.developer?.id) {
        console.error('Developer id is null!');
        console.log(this.developer);
        return;
      }
      return this.gameService.getDeveloperGames(this.developer.id).subscribe(g => this.games = g);
    })).subscribe();
  }
}
