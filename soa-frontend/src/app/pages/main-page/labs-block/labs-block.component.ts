import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {FormControl} from "@angular/forms";
import {MatDialog} from "@angular/material/dialog";
import {LabForm} from "../lab-form/lab-form";
import {HttpService} from "../../../services/http.service";
import {LABS_URL} from "../../../../data/api";
import {Lab, LabMapperDTO} from "../../../types/LabType";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-labs-block',
  templateUrl: './labs-block.component.html',
  styleUrls: ['./labs-block.component.scss']
})
export class LabsBlockComponent implements OnInit {
  public inputField = new FormControl(null);
  public value = '';
  public isOpenPopup = false;
  public labs: Lab[] = [];

  constructor(
    private dialog: MatDialog,
    private _http: HttpService,
    private _snackBar: MatSnackBar,
    private _cdr: ChangeDetectorRef,
  ) {
  }

  ngOnInit(): void {
    this.getLabs();
    //todo remove
    // this.clickAddButton();
  }

  public getLabs() {
    this._http.getData<Lab[]>(LABS_URL).subscribe((res) => {
      this.labs = res;
      this._cdr.markForCheck();
    })
  }

  public clickAddButton() {
    this.isOpenPopup = !this.isOpenPopup;
    this.dialog.open(LabForm).afterClosed()
      .subscribe((lab: Lab) => {
        // @ts-ignore
        this._http.postData(LABS_URL, LabMapperDTO(lab, lab.discipline))
          .subscribe((res) => {
              this._snackBar.open('Lab was successfully add', 'Close', {
                duration: 3000,
              });
              this.getLabs()
            }, (error) => {
              if (error.status == 404) {
                this._snackBar.open('This discipline doesn\'t exist', 'Close', {
                  duration: 5000,
                });
              } else if (error.status == 400) {
                this._snackBar.open('Bad request', 'Close', {
                  duration: 5000,
                });
              }
            }
          )
      });
  }
}
