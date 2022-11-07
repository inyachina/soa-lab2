import {Component, OnInit} from '@angular/core';
import {TestDisciplines} from "../../../../data/Test";
import {MatTableDataSource} from "@angular/material/table";
import {Discipline} from "../../../types/LabType";
import {MatDialog} from "@angular/material/dialog";
import {DisciplineFormComponent} from "../discipline-form/discipline-form.component";

@Component({
  selector: 'app-discipline',
  templateUrl: './discipline.component.html',
  styleUrls: ['./discipline.component.scss']
})
export class DisciplineComponent implements OnInit {
  public dataSource: MatTableDataSource<Discipline> = new MatTableDataSource(TestDisciplines);
  public displayedColumns: string[] = ['name', 'lectureHours', 'selfStudyHours', 'action'];
  private isOpenPopup = false;

  constructor(
    private dialog: MatDialog,
  ) {
  }

  ngOnInit(): void {
    // this.clickAddButton()
  }

  public clickAddButton() {
    this.isOpenPopup = !this.isOpenPopup;
    this.dialog.open(DisciplineFormComponent).afterClosed().subscribe(() => {

    })
  }
}
