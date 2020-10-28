import {Injectable} from "@angular/core";
import {CanActivate, Router} from "@angular/router";
import {TokenStorageService} from "../_services/token-storage.service";

@Injectable()
export class AuthGuardService implements CanActivate {
  constructor(public router: Router, private tokenStorageService: TokenStorageService) {
  }

  canActivate(): boolean {
    if (!this.tokenStorageService.getToken()) {
      this.router.navigate(['register']);
      return false;
    }
    return true;
  }
}
