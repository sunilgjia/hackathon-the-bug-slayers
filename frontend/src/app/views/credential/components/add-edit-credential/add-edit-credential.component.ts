import { Component, OnInit } from "@angular/core";
import { Form, FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Credential } from "../../../../models";
import { CredentialService } from "../../../../services";

@Component({
  templateUrl: "add-edit-credential.component.html",
  styleUrls: ["add-edit-credential.component.css"],
})
export class AddEditCredentialComponent implements OnInit {
  isLoading: boolean = false;
  isFormSubmitted: boolean = false;

  form: FormGroup;

  constructor(
    private fb: FormBuilder,
    private credentialService: CredentialService
  ) {}

  ngOnInit() {
    this.buildForm(new Credential({}));
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
