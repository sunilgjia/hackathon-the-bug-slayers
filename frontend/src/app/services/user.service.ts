import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { GlobalConstant } from "../models";

@Injectable()
export class UserService {
  constructor(private httpClient: HttpClient) {}

  getAll() {
    return this.httpClient.get(GlobalConstant.apiUrl.User.getAll);
  }
}
