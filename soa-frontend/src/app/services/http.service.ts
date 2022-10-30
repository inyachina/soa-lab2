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
export class HttpService implements HttpService {

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
  ): Observable<ApiResponse<R>> {
    return this._http
      .get<ApiResponse<R>>(SERVER_URL + url, {
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
  ): Observable<ApiResponse<R>> {
    return this._http
      .put<ApiResponse<R>>(SERVER_URL + url, body, {
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
  ): Observable<ApiResponse<R>> {
    return this._http
      .post<ApiResponse<R>>(SERVER_URL + url, body, {
        headers: this._createDefaultHeaders(noAuth),
        params: this._removeNullParams(params) || undefined,
      })
      .pipe(
        catchError<any, any>((err: HttpErrorResponse) =>
          this._handleError(err),
        ),
      );
  }

  public deleteData<R>(
    url: string,
    params?: QueryParams,
  ): Observable<ApiResponse<R>> {
    return this._http
      .delete<ApiResponse<R>>(SERVER_URL + url, {
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
    const code = e.status;

    switch (code) {
      case 500:
        this._snackBar.open('Непредвиденная ошибка', 'Закрыть', {
          duration: 3000,
        });
        break;

      case 502:
        this._snackBar.open('Сервис временно недоступен', 'Закрыть', {
          duration: 3000,
        });
        break;

      case 403:

        if (this._router.url.indexOf('/login/') === -1) {
          this._router.navigateByUrl('login');
        }

        break;

      default:
        break;
    }

    return throwError(e);
  }
}
