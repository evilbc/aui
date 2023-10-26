import {Component, OnInit} from '@angular/core';
import {Developer} from "../../developer/model/developer-model";
import {Game} from "../model/game-model";
import {DeveloperService} from "../../developer/service/developer.service";
import {ActivatedRoute} from "@angular/router";
import {GameService} from "../service/game.service";

@Component({
    selector: 'app-game-details',
    templateUrl: './game-details.component.html',
    styleUrls: ['./game-details.component.css']
})
export class GameDetailsComponent implements OnInit {
    game: Game | undefined;
    developer: Developer | undefined;

    constructor(private developerService: DeveloperService, private route: ActivatedRoute, private gameService: GameService) {
    }

    ngOnInit(): void {
        const id: string = this.route.snapshot.paramMap.get('id')!;
        const gameId: string = this.route.snapshot.paramMap.get('gameId')!;
        this.gameService.get(gameId).subscribe(g => this.game = g);
        this.developerService.get(id)
            .subscribe(d => this.developer = d);
    }

}
