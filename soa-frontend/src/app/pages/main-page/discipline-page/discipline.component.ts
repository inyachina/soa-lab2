import {ChangeDetectorRef, Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {Discipline} from "../../../types/LabType";
import {MatDialog} from "@angular/material/dialog";
import {DisciplineFormComponent} from "../discipline-form/discipline-form.component";
import {HttpService} from "../../../services/http.service";
import {DISCIPLINE_URL} from "../../../../data/api";
import {MatSnackBar} from "@angular/material/snack-bar";
import {MatPaginator} from "@angular/material/paginator";
import {SuggestionPopupComponent} from "../../../common/suggestion-popup/suggestion-popup.component";

@Component({
  selector: 'app-discipline',
  templateUrl: './discipline.component.html',
  styleUrls: ['./discipline.component.scss']
})
export class DisciplineComponent implements OnInit {
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  public dataSource= new MatTableDataSource<Discipline>([]);
  public displayedColumns: string[] = ['name', 'lectureHours', 'selfStudyHours', 'action'];
  private isOpenPopup = false;

  constructor(
    private dialog: MatDialog,
    private _http: HttpService,
    private _snackBar: MatSnackBar,
    private _cdr: ChangeDetectorRef,
    private _dialog: MatDialog,
  ) {
  }

  ngOnInit(): void {
    this._http.getData<Discipline[]>(DISCIPLINE_URL).subscribe((res: Discipline[]) => {
        this.dataSource.data = res;
        this.dataSource.paginator = this.paginator;
      }
    )
    //todo remove
    // this.clickAddButton()
  }

  public clickAddButton() {
    this.isOpenPopup = !this.isOpenPopup;
    this.dialog.open(DisciplineFormComponent)
      .afterClosed()
      .subscribe((res) => {
        this._http.postData<Discipline>(DISCIPLINE_URL, res).subscribe(
          (res: Discipline) => {
            this.dataSource.data = [...this.dataSource.data, res]
            this._cdr.detectChanges();
          }, (error => {
            if (error.status == 409) {
              this._snackBar.open('This discipline already exists', 'Close', {
                duration: 30000,
              });
            }
          }))
      })
  }

  public clickDeleteButton(discipline: Discipline) {
    this._dialog.open(SuggestionPopupComponent, {
      data: {
        text: "Are you sure that you want delete this discipline?"
      }
    }).afterClosed().subscribe((res) => {
      if (!res) return;

      this._http.deleteData(DISCIPLINE_URL + `/${discipline.id}`).subscribe((res) =>{
        console.log(res)
      })
    })
  }
}
