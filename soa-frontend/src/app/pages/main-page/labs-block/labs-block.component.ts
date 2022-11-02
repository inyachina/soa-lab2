import {Component, OnInit} from '@angular/core';
import {FormControl} from "@angular/forms";
import {MatDialog} from "@angular/material/dialog";
import {CreateLabPopupComponent} from "../create-lab-popup/create-lab-popup.component";
import {TestLabs} from "../../../../data/Test";

@Component({
  selector: 'app-labs-block',
  templateUrl: './labs-block.component.html',
  styleUrls: ['./labs-block.component.scss']
})
export class LabsBlockComponent implements OnInit {
  public inputField = new FormControl(null);
  public value = '';
  public isOpenPopup = false;

  public labs = TestLabs;

  constructor(
    private dialog: MatDialog
  ) {
  }

  ngOnInit(): void {
    //todo remove
    // this.clickAddButton();
  }

  public clickAddButton() {
    this.isOpenPopup = !this.isOpenPopup;
    this.dialog.open(CreateLabPopupComponent, {panelClass: "custom-dialog-container"}).afterClosed().subscribe(() => {

    })
  }

}
