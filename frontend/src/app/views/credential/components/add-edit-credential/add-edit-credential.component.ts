import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Credential, User } from "../../../../models";
import { CredentialService, UserService } from "../../../../services";

@Component({
  templateUrl: "add-edit-credential.component.html",
  styleUrls: ["add-edit-credential.component.css"],
})
export class AddEditCredentialComponent implements OnInit {
  isLoading: boolean = false;
  isFormSubmitted: boolean = false;

  form: FormGroup;

  users: User[] = [];

  constructor(
    private fb: FormBuilder,
    private credentialService: CredentialService,
    private userService: UserService
  ) {}

  ngOnInit() {
    this.buildForm(new Credential({}));
    this.getUsers();
  }

  public buildForm(data: Credential) {
    this.form = this.fb.group({
      id: [data.id],
      name: [data.name, Validators.required],
      username: [data.username, Validators.required],
      password: [data.password, Validators.required],
      description: [data.description, Validators.required],
    });
    this.isLoading = false;
  }

  get f() {
    return this.form.controls;
  }

  getUsers() {
    this.userService.getAll().subscribe(
      (response: any) => {
        this.users = [];
        this.isFormSubmitted = false;
      },
      (error: any) => {
        this.isLoading = false;
        this.isFormSubmitted = false;
      }
    );
  }

  onSubmit() {
    this.isFormSubmitted = true;

    if (this.form.invalid) {
      return;
    }

    this.isLoading = true;
    const data: Credential = Object.assign(this.form.value);

    this.credentialService.add(data).subscribe(
      (response: any) => {
        this.isFormSubmitted = false;
      },
      (error: any) => {
        this.isLoading = false;
        this.isFormSubmitted = false;
      }
    );
  }
}
