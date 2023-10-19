import {Component, OnInit} from '@angular/core';
import {DeveloperService} from "../service/developer.service";
import {Developer} from "../model/developer-model";
import * as uuid from "uuid";

@Component({
  selector: 'app-developer-add',
  templateUrl: './developer-add.component.html',
  styleUrls: ['./developer-add.component.css']
})
export class DeveloperAddComponent implements OnInit {
  developer: Developer = new FormDeveloper(uuid.v4());

  constructor(private developerService: DeveloperService) {
  }

  ngOnInit(): void {
    this.refresh()
  }

  onSubmit() {
    this.create(this.developer);
    this.refresh();
  }

  create(developer: Developer): void {
    this.developerService.create(developer);
  }

  refresh(): void {
    this.developer = new FormDeveloper(uuid.v4());
  }
}

class FormDeveloper implements Developer {

  constructor(public id: string, public name?: string, public country?: string) {
  }
}
