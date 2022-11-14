import {Component, Input, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {MatRadioChange} from "@angular/material/radio";

@Component({
  selector: 'app-filter-rule',
  templateUrl: './filter-rule.component.html',
  styleUrls: ['./filter-rule.component.scss']
})
export class FilterRuleComponent implements OnInit {

  @Input("property")
  public property!: {
    name: string,
    formGroup: FormGroup
  }

  public filterControl!: FormControl;
  public sortControl!: FormControl;

  constructor() {
  }

  ngOnInit(): void {
    // @ts-ignore
    this.sortControl = this.property.formGroup.controls.sort;
    // @ts-ignore
    this.filterControl = this.property.formGroup.controls.filter;
    console.log(this.sortControl)

  }

  onChangeSort(event: MatRadioChange) {
    this.sortControl.setValue(event.value)
  }
}
