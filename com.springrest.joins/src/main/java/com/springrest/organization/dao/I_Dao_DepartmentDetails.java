package com.springrest.organization.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.organization.entity.Department;

public interface I_Dao_DepartmentDetails extends JpaRepository<Department , Integer> {

}
