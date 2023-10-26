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
      catchError(this.handleError("Nie udało się pobrać listy deweloperów", [])));
  }

  public get(id: string): Observable<Developer> {
    return this.http.get<Developer>(`/api/developers/${id}`).pipe(
      catchError(this.handleError('Nie udało się pobrać danych dewelopera', {id: id, name: '', country: ''})))
      ;
  }

  public delete(developer: Developer): Observable<Developer> {
    return this.http.delete<void>(`/api/developers/${developer.id}`).pipe(
      map(_ => developer),
      tap(_ => this.toast.success("Usunięto")),
      catchError(this.handleError("Nie udało się usunąć dewelopera", developer))
    );
  }

  public create(developer: Developer): Observable<Developer> {
    return this.http.put<void>(`/api/developers/${developer.id}`, developer).pipe(
      map(_ => developer), tap(_ => this.toast.success("Stworzono dewelopera")),
      catchError(this.handleError("Nie udało się stworzyć dewelopera", developer))
    );
  }

  public update(developer: Developer): Observable<Developer> {
    return this.http.patch<void>(`/api/developers/${developer.id}`, developer).pipe(
      map(_ => developer), tap(_ => this.toast.success("Zaktualizowano dewelopera")),
      catchError(this.handleError("Nie udało się zaktualizować dewelopera", developer))
    );
  }

  private handleError<T>(toastTitle: string, result?: T) {
    return (error: any): Observable<T> => {

      console.error(error);

      this.toast.error(error.message, toastTitle)

      return of(result as T);
    };
  }
}
