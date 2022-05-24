package com.nava.springbootproject.repository;

import com.nava.springbootproject.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // no need of mentioning this, spring JpaRepository will automatically add this for Employee entity
public interface EmployeeRepository extends JpaRepository <Employee,Long>  // here we created repository layer for type Employee table and it extends Jpa Repository interface which expects two parameters ...Entity name, primary key type
{
    // now this EmployeeRepository interface gets all the crud database methods to interact with DB

}
