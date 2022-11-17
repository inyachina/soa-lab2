import {Component, OnInit, ViewChild} from '@angular/core';
import {MatAccordion} from "@angular/material/expansion";
import {FormBuilder} from "@angular/forms";

@Component({
  selector: 'app-filter-accordion',
  templateUrl: './filter-accordion.component.html',
  styleUrls: ['./filter-accordion.component.scss']
})
export class FilterAccordionComponent implements OnInit {
  @ViewChild(MatAccordion) accordion!: MatAccordion;

  public filterForm = this._fb.group(
    {
      name: this._fb.group(
        {
          sort: [null],
          filter: [null]
        }
      )
    }
  )
  public properties = [
    {
      name: "Name",
      server_name: "creation_date"
    },
    {
      name: "Creation Date",
      server_name: "creation_date"
    },
    {
      name: "Personal Qualities Maximum",
      server_name: "personalQualitiesMaximum"
    },
    {
      name: "Difficulty",
      server_name: "difficulty"
    }
  ]

  public coordinatesProperties = [
    {
    name: "x",
    server_name: "x"
  },
    {
      name: "y",
      server_name: "y"
    },
  ];
  public disciplineProperties = [
    {
    name: "name",
    server_name: "name"
  },
    {
      name: "Lecture Hours",
      server_name: "lecture_hours"
    },{
      name: "Self Study Hours",
      server_name: "self_study_hours"
    },
  ]

  constructor(
    private _fb: FormBuilder
  ) {
  }

  ngOnInit(): void {
  }

}
