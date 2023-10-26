import {Component, OnInit} from '@angular/core';
import {Developer} from "../../developer/model/developer-model";
import * as uuid from "uuid";
import {DeveloperService} from "../../developer/service/developer.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Location} from "@angular/common";
import {Game} from "../model/game-model";
import {GameService} from "../service/game.service";

@Component({
    selector: 'app-game-add',
    templateUrl: './game-add.component.html',
    styleUrls: ['./game-add.component.css']
})
export class GameAddComponent implements OnInit {
    game: Game = {id: uuid.v4(), name: '', price: 0, year: 0, developerId: ''};
    developerId: string  = '';
    id: string | null = null;

    constructor(private route: ActivatedRoute, private location: Location, private gameService: GameService) {
    }

    ngOnInit(): void {
        this.developerId = <string>this.route.snapshot.paramMap.get('id');
        this.id = this.route.snapshot.paramMap.get('gameId');
        this.refresh()
    }

    onSubmit() {
        if (!this.id) {
            this.gameService.create(this.game).subscribe(_ => this.refresh());
        } else {
            this.gameService.update(this.game).subscribe(_ => this.location.back());
        }
    }

    refresh(): void {
        if (!this.id) {
            this.game = {id: uuid.v4(), name: '', price: 0, year: 0, developerId: this.developerId};
        } else {
            this.gameService.get(this.id).subscribe(g => this.game = g);
        }
    }

    isAddMode(): boolean {
        return !this.id;
    }

}
