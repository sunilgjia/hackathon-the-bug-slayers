import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { GlobalConstant } from "../models";

@Injectable()
export class HttpService {
  constructor(private httpClient: HttpClient) {}

  private getHeaders() {
    let headers = new HttpHeaders();
    const token = localStorage.getItem(GlobalConstant.LocalStorageKey.token);
    if (token) {
      headers.append("Authorization", `Basic ${token}`);
    }
    return headers;
  }

  get(url: string) {
    const headers: HttpHeaders = this.getHeaders();
    return this.httpClient.get(`${GlobalConstant.apiBasePRL}${url}`, {
      headers,
    });
  }

  post(url: string, data: any) {
    const headers: HttpHeaders = this.getHeaders();
    return this.httpClient.post(`${GlobalConstant.apiBasePRL}${url}`, data, {
      headers,
    });
  }

  put(url: string, data: any) {
    const headers: HttpHeaders = this.getHeaders();
    return this.httpClient.put(`${GlobalConstant.apiBasePRL}${url}`, data, {
      headers,
    });
  }

  delete(url: string) {
    const headers: HttpHeaders = this.getHeaders();
    return this.httpClient.delete(`${GlobalConstant.apiBasePRL}${url}`, {
      headers,
    });
  }
}
