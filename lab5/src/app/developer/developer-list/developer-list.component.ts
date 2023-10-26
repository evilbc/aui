import {Component, OnInit} from '@angular/core';
import {Developer} from "../model/developer-model";
import {DeveloperService} from "../service/developer.service";
import {ToastrService} from "ngx-toastr";
import {tap} from "rxjs/operators";

@Component({
  selector: 'app-developer-list',
  templateUrl: './developer-list.component.html',
  styleUrls: ['./developer-list.component.css']
})
export class DeveloperListComponent implements OnInit {
  developers: Developer[] = [];

  constructor(private developerService: DeveloperService) {
  }

  ngOnInit(): void {
    this.refresh();
  }

  refresh(): void {
    this.getDevelopers();
  }

  private getDevelopers(): void {
    this.developerService.getDevelopers().subscribe(developers => this.developers = developers);
  }

  delete(developer: Developer): void {
    this.developerService.delete(developer)
      .subscribe(_ => this.refresh());
  }
}
