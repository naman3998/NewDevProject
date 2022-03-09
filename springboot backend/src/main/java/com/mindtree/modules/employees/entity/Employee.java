package com.mindtree.modules.employees.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.mindtree.modules.certificates.entity.Certifcation;
import com.mindtree.modules.skills.entity.Skill;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "skills")
	private String skills;

	@Column(name = "email_id")
	private String emailId;
	@Temporal(TemporalType.DATE)
	@Column(name = "registration_date")
	private Date registrationDate=new Date(System.currentTimeMillis());
	
	@PrePersist
	public void onCreate() {
		registrationDate=new Date();
	}

	
	public Employee() {

	}

	public Employee(String firstName, String lastName, String emailId, String skills) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.skills = skills;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public String getSkills() {
		return skills;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}
	
	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}


	
	
	
//	private String employeeName;
//	private String email;
//	private String password;
//	private String role;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="employee_skill",joinColumns=@JoinColumn(name="employee_id",referencedColumnName ="id"),inverseJoinColumns = @JoinColumn(name="skill_id",referencedColumnName ="sid" ))
	private List<Skill> skill;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="employee_certificate",joinColumns=@JoinColumn(name="employee_id",referencedColumnName ="id"),inverseJoinColumns = @JoinColumn(name="certificate_id",referencedColumnName ="cid" ))
	private List<Certifcation> certifications;
	
	public List<Certifcation> getCertifications() {
		return certifications;
	}
	public void setCertifications(List<Certifcation> certifications) {
		this.certifications = certifications;
	}
	public void addCertifications(List<Certifcation> certifications) {
		this.certifications.addAll(certifications);
	}
}
//	public List<Skill> getSkills() {
//		return skills;
//	}
//	public void setSkills(List<Skill> skills) {
//		this.skills = skills;
//	}
//	public void addSkills(List<Skill> skills) {
//		this.skills.addAll(skills);
//	}
//	public long getId() {
//		return id;
//	}
//	public void setId(long id) {
//		this.id = id;
//	}
//	public String geteName() {
//		return employeeName;
//	}
//	public void seteName(String eName) {
//		this.employeeName = eName;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	public String getRole() {
//		return role;
//	}
//	public void setRole(String role) {
//		this.role = role;
//	}
//	public Employee(long id, String eName, String email, String password, String role) {
//		super();
//		this.id = id;
//		this.employeeName = eName;
//		this.email = email;
//		this.password = password;
//		this.role = role;
//	}
//	public Employee() {
//		super();
		// TODO Auto-generated constructor stub
	
	
	
	
	
