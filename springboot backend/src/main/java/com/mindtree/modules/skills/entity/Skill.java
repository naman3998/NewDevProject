package com.mindtree.modules.skills.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mindtree.modules.employees.entity.Employee;

@Entity
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sid;
	private String sName;
	
	@JsonIgnore
	@ManyToMany(mappedBy ="skills")
	private List<Employee> employees;
	
	
	
	public Skill(Long sid, String sName) {
		super();
		this.sid = sid;
		this.sName = sName;
	}
	public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}
	
	public Skill() {
		super();
	}
	@Override
	public String toString() {
		return "Skill [sid=" + sid + ", sName=" + sName + ", employees=" + employees + "]";
	}
	
	
}
