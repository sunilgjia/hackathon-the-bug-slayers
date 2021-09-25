import { environment } from "../../environments/environment";
import { API_URL } from "./api.url";

export const GlobalConstant = {
  apiBasePRL: environment.API_URL,
  apiUrl: API_URL,
  LocalStorageKey: {
    token: "token",
    user: "user",
  },
};
