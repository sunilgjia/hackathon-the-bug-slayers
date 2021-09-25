import { Component, OnInit } from "@angular/core";
import { NgbModal } from "@ng-bootstrap/ng-bootstrap";
import { ToastrService } from "ngx-toastr";
import { AddEditCredentialComponent } from "..";
import { Credential } from "../../../../models";
import { CredentialService } from "../../../../services";

@Component({
  templateUrl: "credential-list.component.html",
  styleUrls: ["credential-list.component.css"],
})
export class CredentialListComponent implements OnInit {
  public isLoading: boolean = false;
  public isShared: boolean = false;

  public credentials: Credential[] = [];

  constructor(
    private modalSerivce: NgbModal,
    private credentialSerivce: CredentialService,
    private toastr: ToastrService
  ) {}

  ngOnInit() {
    this.isLoading = true;
    this.getAllCredential();
  }

  changeType() {
    this.credentials = [];
    this.getAllCredential();
  }

  getAllCredential() {
    this.isLoading = true;
    this.credentialSerivce
      .getAll(localStorage.getItem("userId"), this.isShared)
      .subscribe(
        (response: any) => {
          this.credentials = response;
          this.isLoading = false;
        },
        (error: any) => {
          this.toastr.error("Error", error?.message || "Something went wrong");
          this.isLoading = false;
        }
      );
  }

  viewPassword(index: number, value: boolean) {
    this.credentials[index].isPasswordVisible = !value;
  }

  copyToClipBoard(password: string) {
    this.toastr.success("Password copied successfully");
    navigator.clipboard.writeText(password);
  }

  addEdit(id: any) {
    const modalRef = this.modalSerivce.open(AddEditCredentialComponent, {
      size: "lg",
    });
    modalRef.componentInstance.id = id;

    modalRef.result.then((data) => {
      // on close
      this.getAllCredential();
    });
  }

  delete(id: any) {
    this.credentialSerivce.delete(id).subscribe(
      (response: any) => {
        this.toastr.success("Credential copied successfully");
        this.getAllCredential();
      },
      (error: any) => {
        this.toastr.error("Error", error?.message || "Something went wrong");
        this.isLoading = false;
      }
    );
  }
}
