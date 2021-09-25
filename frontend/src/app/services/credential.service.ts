import { Injectable } from "@angular/core";
import { HttpService } from ".";
import { GlobalConstant } from "../models";

@Injectable()
export class CredentialService {
  constructor(private httpSerivce: HttpService) {}

  getAll() {
    return this.httpSerivce.get(GlobalConstant.apiUrl.Credential.getAll);
  }

  getById(id: number) {
    return this.httpSerivce.get(
      `${GlobalConstant.apiUrl.Credential.getById}/${id}`
    );
  }

  add(data: any) {
    return this.httpSerivce.post(GlobalConstant.apiUrl.Credential.add, data);
  }

  put(data: any) {
    return this.httpSerivce.put(GlobalConstant.apiUrl.Credential.update, data);
  }

  delete(id: number) {
    return this.httpSerivce.delete(
      `${GlobalConstant.apiUrl.Credential.delete}/${id}`
    );
  }
}
