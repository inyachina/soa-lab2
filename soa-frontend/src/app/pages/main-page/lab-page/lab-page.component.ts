import { Component, OnInit } from '@angular/core';
import {Lab} from "../../../types/LabType";
import {TestLabs} from "../../../../data/Test";
import {Router} from "@angular/router";
import {MatTabChangeEvent} from "@angular/material/tabs";

@Component({
  selector: 'app-lab-page',
  templateUrl: './lab-page.component.html',
  styleUrls: ['./lab-page.component.scss']
})
export class LabPageComponent implements OnInit {
  public lab!: Lab;

  constructor(
    private _router: Router,
  ) { }

  ngOnInit(): void {
    this.lab = TestLabs[0];
  }

  redirect(tab: string) {
    this._router.navigate(['/'], {
      queryParams: {
        tab
      }
    })
  }

  changeTab(event: MatTabChangeEvent) {
    if (event.index == 1) {
      this.redirect("labs")
    } else {
      this.redirect("disciplines")
    }
  }
}
