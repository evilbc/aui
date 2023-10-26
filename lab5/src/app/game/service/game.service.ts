import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ToastrService} from "ngx-toastr";
import {Observable, of} from "rxjs";
import {catchError, map, tap} from "rxjs/operators";
import {Game, GetGamesDto} from "../model/game-model";
import {Developer} from "../../developer/model/developer-model";

@Injectable({
  providedIn: 'root'
})
export class GameService {

  constructor(
    private http: HttpClient,
    private toast: ToastrService
  ) {
  }

  public getDeveloperGames(developerId: string): Observable<Game[]> {
    return this.http.get<GetGamesDto>(`/api/developers/${developerId}/games`).pipe(
      map(dto => dto?.games ?? []),
      catchError(this.handleError(`Nie udało się pobrać listy gier dewelopera o id ${developerId}`, [])));
  }

  public get(id: string): Observable<Game> {
    return this.http.get<Game>(`/api/games/${id}`).pipe(
      catchError(this.handleError('Nie udało się pobrać danych gry', {
        id: id,
        name: '',
        price: 0,
        year: 0,
        developerId: ''
      })))
      ;
  }

  public delete(game: Game): Observable<Game> {
    return this.http.delete<void>(`/api/games/${game.id}`).pipe(
      map(_ => game),
      tap(_ => this.toast.success("Usunięto")),
      catchError(this.handleError("Nie udało się usunąć gry", game))
    );
  }

  public create(game: Game): Observable<Game> {
    return this.http.put<void>(`/api/games/${game.id}`, game).pipe(
      map(_ => game),
      tap(_ => this.toast.success("Stworzono grę")),
      catchError(this.handleError("Nie udało się stworzyć gry", game))
    );
  }

  public update(game: Game): Observable<Game> {
    return this.http.patch<void>(`/api/games/${game.id}`, game).pipe(
      map(_ => game),
      tap(_ => this.toast.success("Zaktualizowano grę")),
      catchError(this.handleError("Nie udało się zaktualizować gry", game))
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
