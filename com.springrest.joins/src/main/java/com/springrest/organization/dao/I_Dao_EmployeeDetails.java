package com.springrest.organization.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.organization.entity.Employee;

public interface I_Dao_EmployeeDetails extends JpaRepository<Employee, Integer>{

}
