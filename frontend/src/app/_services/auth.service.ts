import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Constants} from "../config/constants";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) {
  }

  login(credentials): Observable<any> {
    return this.http.post(Constants.API_ENDPOINT + 'auth/signin', {
      username: credentials.username,
      password: credentials.password
    }, Constants.HEADERS);
  }

  register(user): Observable<any> {
    return this.http.post(Constants.API_ENDPOINT + 'auth/signup', {
      username: user.username,
      email: user.email,
      password: user.password
    }, Constants.HEADERS);
  }
}
