package com.example.employee;

import com.example.employee.Employee;
import com.example.employee.EmployeeRepository;
import com.example.employee.exception.ResourceNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
   private final EmployeeRepository employeeRepository ;
  
   private final ModelMapper modelMapper;
     
   public EmployeeService(EmployeeRepository employeeRepository,ModelMapper modelMapper) {
	   this.employeeRepository = employeeRepository;
	   this.modelMapper = modelMapper;
   }
   
   public List<Employee> getAllEmployees(){
	   return employeeRepository.findAll();
   }
   
   public EmployeeDTO getEmployeeById(Long id) {
	   Employee employee = employeeRepository.findById(id).get();
	   EmployeeDTO employeeDto = this.modelMapper.map(employee, EmployeeDTO.class);
	   return employeeDto;
	   
   }
   
   public Employee createEmployee(Employee employee) {
	   return employeeRepository.save(employee);
   }
   
   public EmployeeDTO udateEmployee(Long id, Employee updatedEmployee) {
	   EmployeeDTO existingEmployee = getEmployeeById(id);
	   existingEmployee.setName(updatedEmployee.getName());
	   existingEmployee.setAge(updatedEmployee.getAge());
	   existingEmployee.setEmail(updatedEmployee.getEmail());
	   
	   return existingEmployee;
   }
   
   public void deleteEmployee(Long id) {
	   Employee existingEmployee = employeeRepository.findById(id).get();
	   employeeRepository.delete(existingEmployee);
   }
   
}
