import { Component, OnInit } from "@angular/core";
import { AddEditCredentialComponent } from "..";
import { NgbModal, NgbModalRef } from "@ng-bootstrap/ng-bootstrap";

@Component({
  templateUrl: "credential-list.component.html",
  styleUrls: ["credential-list.component.css"],
})
export class CredentialListComponent implements OnInit {
  constructor(private modalSerivce: NgbModal) {}

  ngOnInit() {}
  add() {
    const modalRef = this.modalSerivce.open(AddEditCredentialComponent, {
      size: "lg",
    });
    modalRef.componentInstance.data = {};

    modalRef.result.then(
      (data) => {
        // on close
      },
      (reason) => {
        // on dismiss
      }
    );
  }
}
