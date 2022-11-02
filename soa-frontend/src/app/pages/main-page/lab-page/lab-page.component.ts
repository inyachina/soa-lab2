import { Component, OnInit } from '@angular/core';
import {Lab} from "../../../types/LabType";
import {TestLabs} from "../../../../data/Test";

@Component({
  selector: 'app-lab-page',
  templateUrl: './lab-page.component.html',
  styleUrls: ['./lab-page.component.scss']
})
export class LabPageComponent implements OnInit {
  public lab!: Lab;

  constructor() { }

  ngOnInit(): void {
    this.lab = TestLabs[0];
  }

}
