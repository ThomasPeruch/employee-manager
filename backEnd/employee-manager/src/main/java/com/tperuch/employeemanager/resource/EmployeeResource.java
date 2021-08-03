package com.tperuch.employeemanager.resource;

import com.tperuch.employeemanager.model.Employee;
import com.tperuch.employeemanager.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
        Employee employee = service.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee savedEmployee = service.addEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee){
        Employee updatedEmployee = service.updateEmployee(employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.CREATED);
    }
}
