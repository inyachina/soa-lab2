import {Component, EventEmitter, OnInit, Output, ViewChild} from '@angular/core';
import {MatAccordion} from "@angular/material/expansion";
import {FormBuilder} from "@angular/forms";
import {FilterProperty} from "../../../../types/LabType";

@Component({
  selector: 'app-filter-accordion',
  templateUrl: './filter-accordion.component.html',
  styleUrls: ['./filter-accordion.component.scss']
})
export class FilterAccordionComponent implements OnInit {
  @Output("onSearch") public onSearchEvent = new EventEmitter<FilterProperty[]>();
  @ViewChild(MatAccordion) accordion!: MatAccordion;

  public filterForm = this._fb.group(
    {
      name: this._fb.group(
        {
          sort: [null]
        }
      ),
      x: this._fb.group(
        {
          sort: [null]
        }
      ),
      y: this._fb.group(
        {
          sort: [null]
        }
      ),
      difficulty: this._fb.group(
        {
          sort: [null]
        }
      ),
      minimalPoint: this._fb.group(
        {
          sort: [null]
        }
      ),
      personalQualitiesMaximum: this._fb.group(
        {
          sort: [null]
        }
      )
    }
  )
  public properties: FilterProperty[] = [
    {
      name: "Name",
      formGroup: this.filterForm.controls.name,
      type: "string",
    },
    {
      name: "X",
      formGroup: this.filterForm.controls.x,
      type: "number",
    },
    {
      name: "Y",
      formGroup: this.filterForm.controls.y,
      type: "number",
    },
    {
      name: "Difficulty",
      formGroup: this.filterForm.controls.difficulty,
      type: "string",
    },
    {
      name: "Minimal Points",
      formGroup: this.filterForm.controls.minimalPoint,
      type: "number",
    },
    {
      name: "Personal Qualities Maximum",
      formGroup: this.filterForm.controls.personalQualitiesMaximum,
      type: "number",
    },
  ]

  public disciplineProperties = [
    //   {
    //   name: "name",
    //   server_name: "name"
    // },
    //   {
    //     name: "Lecture Hours",
    //     server_name: "lecture_hours"
    //   },{
    //     name: "Self Study Hours",
    //     server_name: "self_study_hours"
    //   },
  ]

  constructor(
    private _fb: FormBuilder
  ) {
  }

  ngOnInit(): void {
  }

  onChangeSort() {
    // console.log(this.filterForm.getRawValue())
  }

  onSearch() {
    // @ts-ignore
    this.onSearchEvent.emit(this.filterForm.getRawValue())
  }
}
