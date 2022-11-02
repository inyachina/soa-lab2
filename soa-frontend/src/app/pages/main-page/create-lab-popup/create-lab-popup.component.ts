import {ChangeDetectorRef, Component, Input, OnInit} from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {DifficultyType, Discipline} from "../../../types/LabType";
import {map, Observable} from "rxjs";
import {HttpService} from "../../../services/http.service";
import {DISCIPLINE_URL} from "../../../../data/api";

@Component({
  selector: 'app-create-lab-popup',
  templateUrl: './create-lab-popup.component.html',
  styleUrls: ['./create-lab-popup.component.scss']
})
export class CreateLabPopupComponent implements OnInit {
  @Input('editMode')
  public isEditMode = false;
  public DifficultyType = Object.values(DifficultyType);

  public disciplines!: Discipline[];
  public filteredDisciplines!: Observable<Discipline[]>;

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
    private _fb: FormBuilder,
    private _http: HttpService,
    private _cdr: ChangeDetectorRef,
  ) {
  }

  ngOnInit(): void {
    this.filteredDisciplines = this.form.controls.discipline.valueChanges.pipe(
      map(value => this._filter(value || '')
      ),
    )
    this._http.getData<Discipline[]>(DISCIPLINE_URL).pipe(
      // (obs) => this.filteredDisciplines = obs
    ).subscribe((res) => {
      this.disciplines = res;
    })


  }

  private _filter(value: string): Discipline[] {
    const filterValue = value.toLowerCase();
    return this.disciplines.filter(option => option.name.toLowerCase().includes(filterValue));
  }
}
