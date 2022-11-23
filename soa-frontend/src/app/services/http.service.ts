import {
  HttpClient,
  HttpErrorResponse,
  HttpHeaders,
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import {ApiResponse, QueryParams} from "../types/httpType";
import {SERVER_URL} from "../../data/api";
@Injectable({
  providedIn: 'root',
})
export class HttpService {

  constructor(
    private _snackBar: MatSnackBar,
    private _http: HttpClient,
    private _router: Router,
  ) {}

  private _createDefaultHeaders(noAuth?: boolean): HttpHeaders {
    const headers = new HttpHeaders({
      'X-Requested-With': 'XMLHttpRequest',
      'Content-Type': 'application/json',
      'Cache-Control': 'no-cache',
      Pragma: 'no-cache',
    });
    return headers;
  }

  private _removeNullParams(params: QueryParams | undefined): {} | null {
    if (!params) { return null; }

    return Object.entries(params).reduce(
      (a: QueryParams, [k, v]) => (v === null ? a : ((a[k] = v), a)),
      {},
    );
  }

  public getData<R>(
    url: string,
    params?: QueryParams,
  ): Observable<R> {
    return this._http
      .get<R>(SERVER_URL + url, {
        headers: this._createDefaultHeaders(),
        params: this._removeNullParams(params) || undefined,
      })
      .pipe(
        catchError<any, any>((err: HttpErrorResponse) =>
          this._handleError(err),
        ),
      );
  }

  public putData<R>(
    url: string,
    body?: {},
    params?: QueryParams,
  ): Observable<R> {
    return this._http
      .put<R>(SERVER_URL + url, body, {
        headers: this._createDefaultHeaders(),
        params: this._removeNullParams(params) || undefined,
      })
      .pipe(
        catchError<any, any>((err: HttpErrorResponse) =>
          this._handleError(err),
        ),
      );
  }

  public postData<R>(
    url: string,
    body?: {},
    params?: QueryParams,
    noAuth?: boolean,
  ): Observable<R> {
    return this._http
      .post<R>(SERVER_URL + url, body, {
        headers: this._createDefaultHeaders(noAuth),
        params: this._removeNullParams(params) || undefined,
      }).pipe(
        catchError<any, any>((err: HttpErrorResponse) =>
          this._handleError(err),
        ),
      );
  }

  public deleteData<R>(
    url: string,
    params?: QueryParams,
  ): Observable<R> {
    return this._http
      .delete<R>(SERVER_URL + url, {
        headers: this._createDefaultHeaders(),
        params: this._removeNullParams(params) || undefined,
      })
      .pipe(
        catchError<any, any>((err: HttpErrorResponse) =>
          this._handleError(err),
        ),
      );
  }

  private _handleError(e: HttpErrorResponse): Observable<Error> {
    this._snackBar.open(e.error.message || "Something went wrong", 'Close', {
      duration: 3000,
    });

    if (e.status == 404){
      this._router.navigate(['/'],{
        queryParams: {
          tab: 'labs'
        }
      } )
    }
    return throwError(e);
  }
}
