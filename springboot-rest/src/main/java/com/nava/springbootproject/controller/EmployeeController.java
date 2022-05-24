package com.nava.springbootproject.controller;

import com.nava.springbootproject.exception.ResourceNotFoundException;
import com.nava.springbootproject.model.Employee;
import com.nava.springbootproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // by mentioning this, this class becomes SpringMVC RestController capable for handling all HTTP requests
@RequestMapping("/api/e1/employees")   // base URL for accepting rest Api's
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

     @GetMapping
    public List<Employee> getAllEmployees()  // this method is responsible for getting all the records of employees, this method accepts GET request from the client, try to fetch the records from the DB and it will convert that java object into json for the client
    {
             return employeeRepository.findAll();
    }

    // building create employee REST API, this method accepts the json object and convert into java object and save it in DB

   @PostMapping // no need to give employee URL bcoz it is already been added in Base URL ("api/e1/employees")
    public Employee createEmployee(@RequestBody Employee employee) //  this @RequestBody will convert JSON object into Java Object
    {
        return employeeRepository.save(employee);

    }

    // build get employee by Id RESTAPI

    @GetMapping("{id}")   // here this {id} need to binded/passed to method argument 'id', so we should take help of @PathVariable
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id)  // ResponseEntity is a generic class, that returns Entity response to the client
    {
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee Not Exist : " +id));
        return ResponseEntity.ok(employee);
    }


    // build update Employee REST API by ID
  // here clients send the data to be updated by specifying primary key attribute and it that object need to be collected here
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails)
    {
        // first we need to fetch the employee object and then we need to update
        Employee employeeUpdate = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee Not Exist with id " + id));

          employeeUpdate.setFirstName(employeeDetails.getFirstName());
          employeeUpdate.setLastName(employeeDetails.getLastName());
          employeeUpdate.setEmailId(employeeDetails.getEmailId());

          employeeRepository.save(employeeUpdate);
          return ResponseEntity.ok(employeeUpdate);

    }

    // Build Delete Employee  REST API by ID

    @DeleteMapping("{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id)
    {
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not Exist with id " +id));
        employeeRepository.delete(employee);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);  // since we are not returning anything
    }


}
