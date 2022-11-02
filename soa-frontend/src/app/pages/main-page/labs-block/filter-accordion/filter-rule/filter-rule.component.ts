import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-filter-rule',
  templateUrl: './filter-rule.component.html',
  styleUrls: ['./filter-rule.component.scss']
})
export class FilterRuleComponent implements OnInit {

  @Input("property")
  public property!: any;

  constructor() { }

  ngOnInit(): void {
  }

}
