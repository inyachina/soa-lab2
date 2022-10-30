export interface ApiResponse<R> {
  isSuccess: boolean;
  type: string;
  data: R;
}

export interface QueryParams {
  [key: string]: any;
}
