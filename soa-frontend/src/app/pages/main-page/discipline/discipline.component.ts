import { Component, OnInit } from '@angular/core';
import {TestDisciplines, TestLabs} from "../../../../data/Test";
import {DataSource} from "@angular/cdk/collections";
import {MatTableDataSource} from "@angular/material/table";
import {Discipline} from "../../../types/LabType";

@Component({
  selector: 'app-discipline',
  templateUrl: './discipline.component.html',
  styleUrls: ['./discipline.component.scss']
})
export class DisciplineComponent implements OnInit {
  public dataSource: MatTableDataSource<Discipline> = new MatTableDataSource(TestDisciplines);
  public displayedColumns: string[] = [ 'name', 'lectureHours', 'selfStudyHours', 'action'];

  constructor() { }

  ngOnInit(): void {
  }

}
