package com.example.employee;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.employee.Employee;
import com.example.employee.EmployeeService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
   private final EmployeeService employeeservice;
   
   public EmployeeController(EmployeeService employeeservice) {
	   this.employeeservice = employeeservice;
   }
   
   @GetMapping
   public ResponseEntity<List<Employee>> getAllEmployees(){
	   List<Employee> employeeList = employeeservice.getAllEmployees();
	   return new ResponseEntity<>(employeeList,HttpStatus.OK);
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
	   return new ResponseEntity<>(employeeservice.getEmployeeById(id),HttpStatus.OK);
   }
   
   @PostMapping
   public ResponseEntity<Employee>createEmployee(@Valid @RequestBody Employee employee){
	   return new ResponseEntity<>(employeeservice.createEmployee(employee),HttpStatus.CREATED);
   }
   
   @PutMapping("/{id}")
   public ResponseEntity<Employee>udateEmployee(@PathVariable Long id,@Valid @RequestBody Employee employee){
	   return new ResponseEntity<>(employeeservice.udateEmployee(id, employee),HttpStatus.OK);
   }
   
   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){
	   employeeservice.deleteEmployee(id);
	   return ResponseEntity.noContent().build();
   }
   
   
}
