package com.met.iit.cdac.springbootjpa.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

import com.met.iit.cdac.springbootjpa.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	
	
	//Repository<T, ID>
	//CrudRepository<T, ID>
	//PagingAndSortingRepository<T, ID>
	//JpaRepository
}
