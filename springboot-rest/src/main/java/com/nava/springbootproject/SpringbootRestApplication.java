package com.nava.springbootproject;

import com.nava.springbootproject.model.Employee;
import com.nava.springbootproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootRestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {

		Employee employee = new Employee();
		employee.setFirstName("Navaneeth");
		employee.setLastName("Kodam");
		employee.setEmailId("navaneethkodam@gmail.com");
		employeeRepository.save(employee);   // this method of employeeRepository object saves this employee object in database

		//inserting second entry in Employee table with new object of Employee

		Employee employee1 = new Employee();
		employee1.setFirstName("Mitul");
		employee1.setLastName("Raju");
		employee1.setEmailId("k.nithin32@gmaiol.com");
		employeeRepository.save(employee1);

	}
}
