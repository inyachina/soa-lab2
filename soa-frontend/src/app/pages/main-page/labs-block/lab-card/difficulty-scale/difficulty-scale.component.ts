import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-difficulty-scale',
  templateUrl: './difficulty-scale.component.html',
  styleUrls: ['./difficulty-scale.component.scss']
})
export class DifficultyScaleComponent implements OnInit {
  @Input("difficulty")
  public difficulty!: string;

  public amount = 1;

  constructor() {
  }

  ngOnInit(): void {
    switch (this.difficulty) {
      case 'VERY_EASY':
        this.amount = 1;
        break;
      case 'NORMAL':
        this.amount = 2;
        break;
      case 'VERY_HARD':
        this.amount = 3;
        break;
      case 'IMPOSSIBLE':
        this.amount = 4;
        break;
      case 'INSANE':
        this.amount = 5;

    }

  }

}
