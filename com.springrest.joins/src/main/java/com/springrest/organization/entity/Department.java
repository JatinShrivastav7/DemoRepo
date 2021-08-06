package com.springrest.organization.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Department {
@Id
private int department_id;
private String department_name;
private String department_floor;

//Bidirectional Mapping
@OneToMany(mappedBy="department",
             cascade = { CascadeType.PERSIST,CascadeType.MERGE ,CascadeType.DETACH,CascadeType.REFRESH })
@JsonBackReference
private List<Employee> employeesList;



//no-args constructor
public Department() {
	super();
}

//parameterized constructor
public Department(int department_id, String department_name, String department_floor) {
	super();
	this.department_id = department_id;
	this.department_name = department_name;
	this.department_floor = department_floor;
}

//Getters and setters
public int getDepartment_id() {
	return department_id;
}
public void setDepartment_id(int department_id) {
	this.department_id = department_id;
}
public String getDepartment_name() {
	return department_name;
}
public void setDepartment_name(String department_name) {
	this.department_name = department_name;
}
public String getDepartment_floor() {
	return department_floor;
}
public void setDepartment_floor(String department_floor) {
	this.department_floor = department_floor;
}

@Override
public String toString() {
	return "Department [department_id=" + department_id + ", department_name=" + department_name + ", department_floor="
			+ department_floor + "]";
}

}


