export interface Developer {
  id: string;
  name: string;
  country: string;
}

export interface GetDevelopersDto {
  developers: Developer[];
}

