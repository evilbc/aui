import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, of} from "rxjs";
import {Developer, GetDevelopersDto} from "../model/developer-model";
import {ToastrService} from "ngx-toastr";
import {catchError, map, tap} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class DeveloperService {

  constructor(
    private http: HttpClient,
    private toast: ToastrService
  ) {
  }

  public getDevelopers(): Observable<Developer[]> {
    return this.http.get<GetDevelopersDto>('/api/developers').pipe(
      map(dto => dto?.developers ?? []),
      catchError(this.handleError("Nie udało się pobrać listy developerów", [])));
  }

  public delete(developer: Developer): void {
    this.http.delete<void>(`/api/developers/${developer.id}`).pipe(
      tap(_ => this.toast.success("Usunięto")),
      catchError(this.handleError("Nie udało się usunąć developera"))
    ).subscribe();
  }

  public create(developer: Developer): void {
    this.http.put<void>(`/api/developers/${developer.id}`, developer).pipe(tap(_ => this.toast.success("Stworzono")),
      catchError(this.handleError("Nie udało się stworzyć developera"))
    ).subscribe();
  }

  private handleError<T>(toastTitle: string, result?: T) {
    return (error: any): Observable<T> => {

      console.error(error);

      this.toast.error(error.message, toastTitle)

      return of(result as T);
    };
  }
}
