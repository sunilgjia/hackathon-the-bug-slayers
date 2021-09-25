import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { HttpService } from ".";
import { GlobalConstant } from "../models";

@Injectable()
export class UserService {
  constructor(private httpService: HttpService) {}

  getAll(userId: string) {
    return this.httpService.get(`${GlobalConstant.apiUrl.User.getAll}/${userId}`);
  }
}
