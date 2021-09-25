export class Credential {
  id: number;
  name: string;
  username: string;
  password: string;
  description: string;

  constructor(data) {
    this.id = data.id || 0;
    this.name = data.name || "";
    this.username = data.username || "";
    this.password = data.password || "";
    this.description = data.description || "";
  }
}
