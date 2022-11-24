import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {LabForm} from "../lab-form/lab-form";
import {HttpService} from "../../../services/http.service";
import {LABS_URL} from "../../../../data/api";
import {DifficultyType, Lab, LabMapperDTO} from "../../../types/LabType";
import {MatSnackBar} from "@angular/material/snack-bar";
import {AveragePopupComponent} from "./average-popup/average-popup.component";
import {DeletePopupComponent} from "./delete-popup/delete-popup.component";

@Component({
  selector: 'app-labs-block',
  templateUrl: './labs-block.component.html',
  styleUrls: ['./labs-block.component.scss']
})
export class LabsBlockComponent implements OnInit {
  public labs: Lab[] = [];
  public pageIndex = 0;
  public pageSize = 15;
  public pageSizeOptions = [5, 10, 15, 25, 50, 100];
  public labAmount?: number;

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


  public getLabs(filter?: string) {
    this._http.getData<number>(LABS_URL + '/amount').subscribe((res) => {
      this.labAmount = res;
    })
    this._http.getData<Lab[]>(LABS_URL, {
      page: this.pageIndex,
      size: this.pageSize,
      filter: "x>=2,name==\"name\""
      // sort: filter || null
    }).subscribe((res) => {
      this.labs = res;
      this._cdr.markForCheck();
    })
  }

  public clickAddButton() {
    this.dialog.open(LabForm).afterClosed()
      .subscribe((lab: Lab) => {
        // @ts-ignore
        this._http.postData(LABS_URL, LabMapperDTO(lab, lab.discipline))
          .subscribe((res) => {
              this._snackBar.open('Lab was successfully add', 'Close', {
                duration: 3000,
              });
              this.getLabs()
            }
          )
      });
  }

  clickAverageMinPointButton() {
    this._http.getData<number>(LABS_URL + '/average/minimal_point').subscribe((res) => {
      this.dialog.open(AveragePopupComponent, {
        data: res,
        panelClass: 'green-dialog'
      })
    })
  }

  clickDeleteByDifficultyButton() {
    this.dialog.open(DeletePopupComponent).afterClosed().subscribe((
      res: {
        flag: boolean,
        difficultyType: DifficultyType
      }
    ) => {
      if (!res.flag) return;

      this._http.deleteData<number>(LABS_URL + '/delete_by/difficulty', {difficulty: res.difficultyType})
        .subscribe((res) => {
          this._snackBar.open('Lab was successfully deleted', 'Close', {
            duration: 3000,
          });
          this.getLabs();
        })
    })

  }

  onPageChange($event: any) {
    this.pageSize = $event.pageSize
    this.pageIndex = $event.pageIndex
    this.getLabs()
  }

  searchLabs(filterProperties: any) {
    this.getLabs(this._parseParams(filterProperties))
  }

  private _parseParams(filterProperties: any) {

    // @ts-ignore
    let clearFilterProperties = Object.fromEntries(Object.entries(filterProperties).filter(([_, v]) => v.sort != null));
    for (const param in clearFilterProperties){
      console.log(param)
    }
    return "clearFilterProperties";
  }
}
