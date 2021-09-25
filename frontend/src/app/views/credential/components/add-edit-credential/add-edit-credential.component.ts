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
  isLoading: boolean = true;
  isFormSubmitted: boolean = false;

  credential: Credential = new Credential({});

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
    if (this.id === 0) {
      this.buildForm(new Credential({}));
    } else {
      this.getCredential();
    }
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

  getCredential() {
    this.credentialService.getById(this.id).subscribe(
      (response: any) => {
        this.credential = new Credential({ response });
        this.buildForm(this.credential);
        this.isFormSubmitted = false;
      },
      (error: any) => {
        this.buildForm(this.credential);
        this.toastr.error("Error", error?.message || "Something went wrong");
        this.isLoading = false;
        this.isFormSubmitted = false;
      }
    );
  }

  getUsers() {
    this.userService.getAll(localStorage.getItem("userId")).subscribe(
      (response: any) => {
        this.users = response;
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
    console.log("onSubmit ");
    this.isFormSubmitted = true;
    if (this.form.invalid) {
      return;
    }

    this.isLoading = true;
    const data: Credential = Object.assign(this.form.value);

    if (this.id === 0) {
      this.credentialService.add(data).subscribe(
        (response: any) => {
          this.isFormSubmitted = false;
          this.toastr.success("Success", "Credential added successfully");
        },
        (error: any) => {
          this.isLoading = false;
          this.toastr.error("Error", error?.message || "Something went wrong");
          this.isFormSubmitted = false;
        }
      );
    } else {
      this.credentialService.put(data).subscribe(
        (response: any) => {
          this.isFormSubmitted = false;
          this.toastr.success("Success", "Credential update successfully");
        },
        (error: any) => {
          this.isLoading = false;
          this.toastr.error("Error", error?.message || "Something went wrong");
          this.isFormSubmitted = false;
        }
      );
    }
  }
}
