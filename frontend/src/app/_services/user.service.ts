import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Constants} from "../config/constants";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  //TODO dont needed
  constructor(private http: HttpClient) {
  }

  getPublicContent(): Observable<any> {
    return this.http.get(Constants.API_ENDPOINT + 'all', {responseType: 'text'});
  }

  getUserBoard(): Observable<any> {
    return this.http.get(Constants.API_ENDPOINT + 'user', {responseType: 'text'});
  }

  getModeratorBoard(): Observable<any> {
    return this.http.get(Constants.API_ENDPOINT + 'mod', {responseType: 'text'});
  }

  getAdminBoard(): Observable<any> {
    return this.http.get(Constants.API_ENDPOINT + 'admin', {responseType: 'text'});
  }
}
