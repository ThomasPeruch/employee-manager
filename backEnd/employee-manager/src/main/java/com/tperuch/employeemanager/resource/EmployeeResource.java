package com.tperuch.employeemanager.resource;

import com.tperuch.employeemanager.model.Employee;
import com.tperuch.employeemanager.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {

    private final EmployeeService service;

    public EmployeeResource(EmployeeService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> employees = service.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
