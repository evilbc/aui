export interface Game {
  id: string;
  name: string;
  price: number;
  year: number;
  developerId: string;
}

export interface GetGamesDto {
  games: Game[];
}
