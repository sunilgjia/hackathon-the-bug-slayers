export class Credential {
  id: number;
  name: string;
  userName: string;
  password: string;
  description: string;
  userId: number;
  
  canView: string;
  canEdit: string;
  canDelete: string;
  isPasswordVisible: boolean;

  constructor(data) {
    this.id = data.id || 0;
    this.name = data.name || "";
    this.userName = data.userName || "";
    this.password = data.password || "";
    this.description = data.description || "";

    this.userId = data.userId || 0;

    this.canView = data.canView || false;
    this.canDelete = data.canDelete || false;
    this.canEdit = data.canEdit || false;
    this.isPasswordVisible = data.isPasswordVisible || false;
  }
}
