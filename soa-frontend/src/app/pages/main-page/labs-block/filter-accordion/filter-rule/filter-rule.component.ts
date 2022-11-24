import {ChangeDetectorRef, Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormControl} from "@angular/forms";
import {FilterFormGroup, FilterProperty, PropertyFormGroup} from "../../../../../types/LabType";

@Component({
  selector: 'app-filter-rule',
  templateUrl: './filter-rule.component.html',
  styleUrls: ['./filter-rule.component.scss']
})
export class FilterRuleComponent implements OnInit {
  @Output("changeSort")
  public changeSortEvent = new EventEmitter<FilterProperty>();
  @Input("propertyFormGroup")
  public propertyFormGroup!: PropertyFormGroup

  public filterFormGroup!: FilterFormGroup;
  public sortControl!: FormControl;
  public name!: string;
  public type!: string;

  constructor(private _cdr: ChangeDetectorRef) {
  }

  ngOnInit(): void {
    this.filterFormGroup = this.propertyFormGroup.controls.filter;
    this.sortControl = this.propertyFormGroup.controls.sort;
    this.name = this.propertyFormGroup.controls.name.getRawValue();
    this.type = this.propertyFormGroup.controls.type.getRawValue();
  }

  isDirtyForm= () =>  this.sortControl.dirty || this.filterFormGroup.controls.rule.dirty || this.filterFormGroup.controls.value.dirty

  isNumber = () =>  this.type == "number"


  clearForm() {
    this.sortControl.setValue(null)
    this.filterFormGroup.controls.rule.setValue(null)
    this.filterFormGroup.controls.value.setValue(null)
    this.sortControl.markAsPristine()
    this.filterFormGroup.controls.rule.markAsPristine()
    this.filterFormGroup.controls.value.markAsPristine()
  }
}
