import { Component, Input, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { NgbActiveModal } from "@ng-bootstrap/ng-bootstrap";
import { Credential, User } from "../../../../models";
import { CredentialService, UserService } from "../../../../services";
import { ToastrService } from "ngx-toastr";

@Component({
  templateUrl: "add-edit-credential.component.html",
  styleUrls: ["add-edit-credential.component.css"],
})
export class AddEditCredentialComponent implements OnInit {
  isLoading: boolean = false;
  isFormSubmitted: boolean = false;

  @Input() public id;

  form: FormGroup;

  users: User[] = [];

  constructor(
    private fb: FormBuilder,
    private credentialService: CredentialService,
    private userService: UserService,
    public activeModal: NgbActiveModal,
    private toastr: ToastrService
  ) {}

  ngOnInit() {
    console.log(this.id);
    this.buildForm(new Credential({}));
    this.getUsers();
  }

  public buildForm(data: Credential) {
    this.form = this.fb.group({
      id: [data.id],
      name: [data.name, Validators.required],
      userName: [data.userName, Validators.required],
      password: [data.password, Validators.required],
      description: [data.description, Validators.required],
    });
    this.isLoading = false;
  }

  get f() {
    return this.form.controls;
  }

  getUsers() {
    this.userService.getAll(localStorage.getItem("userId")).subscribe(
      (response: any) => {
        this.users = response;
        this.isFormSubmitted = false;
      },
      (error: any) => {
        this.toastr.error("Error", error?.message || "Something went wrong");
        this.isLoading = false;
        this.isFormSubmitted = false;
      }
    );
  }

  public close(status: boolean) {
    this.activeModal.close(status);
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
        this.toastr.error("Error", error?.message || "Something went wrong");
        this.isFormSubmitted = false;
      }
    );
  }
}
