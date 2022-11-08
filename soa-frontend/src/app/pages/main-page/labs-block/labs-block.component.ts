import {Component, OnInit} from '@angular/core';
import {FormControl} from "@angular/forms";
import {MatDialog} from "@angular/material/dialog";
import {LabForm} from "../lab-form/lab-form";
import {TestLabs} from "../../../../data/Test";
import {HttpService} from "../../../services/http.service";

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
    private dialog: MatDialog,
    private _http: HttpService,
  ) {
  }

  ngOnInit(): void {
    //todo remove
    // this.clickAddButton();
  }

  public clickAddButton() {
    this.isOpenPopup = !this.isOpenPopup;
    this.dialog.open(LabForm).afterClosed().subscribe((lab) => {
      console.log(lab)
    })
  }

}
