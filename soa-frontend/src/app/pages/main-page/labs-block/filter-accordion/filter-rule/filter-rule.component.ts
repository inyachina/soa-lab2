import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormControl} from "@angular/forms";
import {MatRadioChange} from "@angular/material/radio";
import {FilterProperty} from "../../../../../types/LabType";

@Component({
  selector: 'app-filter-rule',
  templateUrl: './filter-rule.component.html',
  styleUrls: ['./filter-rule.component.scss']
})
export class FilterRuleComponent implements OnInit {
  @Output("changeSort")
  public changeSortEvent = new EventEmitter<FilterProperty>();
  @Input("property")
  public property!: FilterProperty

  public filterControl!: FormControl;
  public sortControl!: FormControl<any>;

  constructor() {
  }

  ngOnInit(): void {
    this.sortControl = this.property.formGroup?.controls['sort'] as FormControl;
    // console.log(this.sortControl)
    // this.filterControl = this.property.formGroup.controls.filter;

  }

  public isDirtyForm() {
    return this.filterControl?.dirty || this.sortControl?.dirty
  }

  onChangeSort(event: MatRadioChange) {
    this.sortControl.setValue(event.value)
    this.changeSortEvent.emit(this.property)
  }
}
