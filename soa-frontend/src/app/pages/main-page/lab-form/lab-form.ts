import {ChangeDetectorRef, Component, Input, OnInit} from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {DifficultyType, Discipline, Lab} from "../../../types/LabType";
import {map, Observable} from "rxjs";
import {HttpService} from "../../../services/http.service";
import {DISCIPLINE_URL} from "../../../../data/api";
import {MatDialog} from "@angular/material/dialog";
import {SuggestionPopupComponent} from "../../../common/suggestion-popup/suggestion-popup.component";

@Component({
  selector: 'app-lab-form',
  templateUrl: './lab-form.html',
  styleUrls: ['./lab-form.scss']
})
export class LabForm implements OnInit {
  @Input('editMode')
  public isEditMode = false;

  @Input('lab')
  public lab!: Lab;
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
    private _dialog: MatDialog,
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

  isFormChanged() {

  }

  deleteLab() {
    this._dialog.open(SuggestionPopupComponent, {data: {
      text: "Are you sure that you want delete this lab?"
      }})
  }
}
