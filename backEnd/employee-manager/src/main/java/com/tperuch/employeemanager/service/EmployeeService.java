package com.tperuch.employeemanager.service;

import com.tperuch.employeemanager.exception.UserNotFoundException;
import com.tperuch.employeemanager.model.Employee;
import com.tperuch.employeemanager.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> findAllEmployees(){
        return repository.findAll();
    }

    public Employee findEmployeeById(Long id){
        return repository.findById(id).orElseThrow(() ->
                new UserNotFoundException("User with id " + id + "was not found"));
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return repository.save(employee);
    }

    public Employee updateEmployee(Employee employee){
        return repository.save(employee);
    }

    public void deleteEmployee(Long id){
        repository.deleteById(id);
    }
}
