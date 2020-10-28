import {Injectable} from '@angular/core';
import {HttpHeaders} from "@angular/common/http";

@Injectable()
export class Constants {
  public static API_ENDPOINT = 'http://localhost:8080/api/';
  public static HEADERS = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };
}
