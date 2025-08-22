package com.example.employee;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class EmployeeDTO {
	
	@NotBlank(message = "Name cannot be blank")
	private String name;
	
	@Email(message = "Invalid email format")
    @NotBlank(message = "Email cannot be blank")
	private String email;
	
	@Min(value=18, message="Age must be atleast 18")
	private int age;
	
	public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    
    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}
}
