import {Component, OnInit} from '@angular/core';
import {DeveloperService} from "../service/developer.service";
import {Developer} from "../model/developer-model";
import * as uuid from "uuid";
import {ActivatedRoute, Router} from "@angular/router";
import {Location} from '@angular/common'

@Component({
    selector: 'app-developer-add',
    templateUrl: './developer-add.component.html',
    styleUrls: ['./developer-add.component.css']
})
export class DeveloperAddComponent implements OnInit {
    developer: Developer = {id: uuid.v4(), name: '', country: ''};
    id: string | null = null;

    constructor(private developerService: DeveloperService, private route: ActivatedRoute, private location: Location) {
    }

    ngOnInit(): void {
        this.id = this.route.snapshot.paramMap.get('id');
        this.refresh()
    }

    onSubmit(): void {
        if (!this.id) {
            this.developerService.create(this.developer).subscribe(_ => this.refresh());
        } else {
            this.developerService.update(this.developer).subscribe(_ => this.location.back());
        }
    }

    refresh(): void {
        if (!this.id) {
            this.developer = {id: uuid.v4(), name: '', country: ''};
        } else {
            this.developerService.get(this.id).subscribe(d => this.developer = d);
        }
    }

    isAddMode(): boolean {
        return !this.id;
    }
}
