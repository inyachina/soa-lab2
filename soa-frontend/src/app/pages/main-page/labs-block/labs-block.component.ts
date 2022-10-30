import {Component, OnInit} from '@angular/core';
import {FormControl} from "@angular/forms";
import {MatDialog} from "@angular/material/dialog";
import {CreateLabPopupComponent} from "../create-lab-popup/create-lab-popup.component";

@Component({
  selector: 'app-labs-block',
  templateUrl: './labs-block.component.html',
  styleUrls: ['./labs-block.component.scss']
})
export class LabsBlockComponent implements OnInit {
  public inputField = new FormControl(null);
  public value = 'zhoopa';
  public isOpenPopup = false;

  constructor(
    private dialog: MatDialog
  ) {
  }

  ngOnInit(): void {
    this.clickAddButton();
  }

  public clickAddButton() {
    this.isOpenPopup = !this.isOpenPopup;
    this.dialog.open(CreateLabPopupComponent, {panelClass: "custom-dialog-container"}).afterClosed().subscribe(() => {
      console.log("lala");
    })
  }

}
