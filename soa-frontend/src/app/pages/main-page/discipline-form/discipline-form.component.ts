import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";

@Component({
  selector: 'app-discipline-form',
  templateUrl: './discipline-form.component.html',
  styleUrls: ['./discipline-form.component.scss']
})
export class DisciplineFormComponent implements OnInit {
  public form =  this._fb.group(
    {
      name: [null, Validators.required],
      lectureHours: [null, Validators.required],
      selfStudyHours: [null, Validators.required]
    });

  constructor(
    private _fb: FormBuilder,) { }

  ngOnInit(): void {
  }

}
