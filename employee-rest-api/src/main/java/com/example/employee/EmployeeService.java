package com.example.employee;

import com.example.employee.Employee;
import com.example.employee.EmployeeRepository;
import com.example.employee.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
   private final EmployeeRepository employeeRepository ;
   
   public EmployeeService(EmployeeRepository employeeRepository) {
	   this.employeeRepository = employeeRepository; 
   }
   
   public List<Employee> getAllEmployees(){
	   return employeeRepository.findAll();
   }
   
   public Employee getEmployeeById(Long id) {
	   return employeeRepository.findById(id)
			  .orElseThrow(()->new ResourceNotFoundException("Employee not found with id " + id) );
   }
   
   public Employee createEmployee(Employee employee) {
	   return employeeRepository.save(employee);
   }
   
   public Employee udateEmployee(Long id, Employee updatedEmployee) {
	   Employee existingEmployee = getEmployeeById(id);
	   existingEmployee.setName(updatedEmployee.getName());
	   existingEmployee.setAge(updatedEmployee.getAge());
	   existingEmployee.setEmail(updatedEmployee.getEmail());
	   
	   return existingEmployee;
   }
   
   public void deleteEmployee(Long id) {
	   Employee existingEmployee = getEmployeeById(id);
	   employeeRepository.delete(existingEmployee);
   }
   
}
