import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {MainPageComponent} from "./pages/main-page/main-page.component";
import {HeaderComponent} from './common/header/header.component';
import {FooterComponent} from './common/footer/footer.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatIconModule} from "@angular/material/icon";
import {MatInputModule} from "@angular/material/input";
import {MatButtonModule} from "@angular/material/button";
import {MatDialogModule} from "@angular/material/dialog";
import {MatAutocompleteModule} from "@angular/material/autocomplete";
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {CreateLabPopupComponent} from './pages/main-page/create-lab-popup/create-lab-popup.component';
import {IntroBlockComponent} from './pages/main-page/intro-block/intro-block.component';
import {LabsBlockComponent} from './pages/main-page/labs-block/labs-block.component';
import {MatSelectModule} from "@angular/material/select";
import {MatTableModule} from "@angular/material/table";
import {MatCardModule} from "@angular/material/card";
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatTabsModule} from '@angular/material/tabs';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatExpansionModule} from '@angular/material/expansion';
import {HttpClientModule} from '@angular/common/http';
import {DisciplineComponent} from './pages/main-page/discipline/discipline.component';
import {FilterAccordionComponent} from './pages/main-page/labs-block/filter-accordion/filter-accordion.component';
import {MatCheckboxModule} from "@angular/material/checkbox";
import {MatRadioModule} from "@angular/material/radio";
import {FilterRuleComponent} from './pages/main-page/labs-block/filter-accordion/filter-rule/filter-rule.component';
import {LabCardComponent} from './pages/main-page/labs-block/lab-card/lab-card.component';
import {DifficultyScaleComponent} from './pages/main-page/labs-block/lab-card/difficulty-scale/difficulty-scale.component';
import {MatMenuModule} from "@angular/material/menu";
import {RouterModule, Routes} from "@angular/router";
import { NotFountPageComponent } from './pages/main-page/not-fount-page/not-fount-page.component';
import { LabPageComponent } from './pages/main-page/lab-page/lab-page.component';

const appRoutes: Routes = [
  {path: '', component: MainPageComponent},
  {path: 'lab', component: LabPageComponent},
  {path: '**', component: NotFountPageComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    MainPageComponent,
    HeaderComponent,
    FooterComponent,
    IntroBlockComponent,
    LabsBlockComponent,
    CreateLabPopupComponent,
    DisciplineComponent,
    FilterAccordionComponent,
    FilterRuleComponent,
    LabCardComponent,
    DifficultyScaleComponent,
    NotFountPageComponent,
    LabPageComponent,
  ],
  imports: [
    ReactiveFormsModule,
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    FormsModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
    MatDialogModule,
    MatButtonModule,
    MatAutocompleteModule,
    MatFormFieldModule,
    MatSelectModule,
    MatSnackBarModule,
    MatInputModule,
    MatCardModule,
    MatTableModule,
    MatExpansionModule,
    MatTabsModule,
    MatCheckboxModule,
    MatRadioModule,
    MatMenuModule,
    MatPaginatorModule, BrowserModule, RouterModule.forRoot(appRoutes)
  ],
  providers: [HttpClientModule],
  bootstrap: [AppComponent]
})
export class AppModule {
}
