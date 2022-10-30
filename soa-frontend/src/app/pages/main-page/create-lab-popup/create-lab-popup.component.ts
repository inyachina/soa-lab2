import {Component, OnInit} from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {DifficultyType} from "../../../types/LabType";
import {map, Observable, startWith} from "rxjs";

@Component({
  selector: 'app-create-lab-popup',
  templateUrl: './create-lab-popup.component.html',
  styleUrls: ['./create-lab-popup.component.scss']
})
export class CreateLabPopupComponent implements OnInit {
  public DifficultyType = Object.values(DifficultyType);

  public disciplines: string[] = ['soa', 'proga', 'tpo'];
  public filteredDisciplines!: Observable<string[]>;

  public form = this._fb.group(
    {
      name: [null, Validators.required],
      x: [null, Validators.compose([Validators.required, Validators.max(295)])],
      y: null,
      creationDate: [null, Validators.required],
      minimalPoint: [null, Validators.required],
      personalQualitiesMaximum: [null, Validators.required],
      difficulty: [null, Validators.required],
      discipline: [null, Validators.required],
    }
  );

  constructor(
    private _fb: FormBuilder
  ) {
  }

  ngOnInit(): void {
    this.filteredDisciplines = this.form.controls.discipline.valueChanges.pipe(
      startWith(''),
      map(value => this._filter(value || '')),
    );
  }

  private _filter(value: string): string[] {
    const filterValue = value.toLowerCase();

    return this.disciplines.filter(option => option.toLowerCase().includes(filterValue));
  }
}
