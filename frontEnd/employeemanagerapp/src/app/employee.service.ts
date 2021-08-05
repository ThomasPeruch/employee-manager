import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
    providedIn: 'root'
})
export class EmployeeService {
    private apiServerUrl = '';

    constructor(private http: HttpClient){}

    public getEmployees(): Observable<Employee[]> {
        return this.http.get<any>(`${this.apiServerUrl}/employee`)
    }

    public addEmployees(employee: Employee): Observable<Employee> {
        return this.http.post<any>(`${this.apiServerUrl}/employee`, employee)
    }

    public updateEmployees(id: number, employee: Employee): Observable<Employee> {
        return this.http.put<any>(`${this.apiServerUrl}/employee/${id}`, employee)
    }

    public deleteEmployees(id: number): Observable<void> {
        return this.http.delete<any>(`${this.apiServerUrl}/employee/${id}`)
    }
}