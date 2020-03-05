package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee99")
public class Employee 
{
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="empcode", length=5)
	private int empcode;
	@Column(name="empname", length=25)
	private String empname;
	@Column(name="address", length=25)
	private String address;
	@Column(name="designation", length=20)
	private String designation;
	@Column(name="mobile", length=10)
	private String mobile;
	@Column(name="email", length=25)
	private String email;
	public int getEmpcode() {
		return empcode;
	}
	public void setEmpcode(int empcode) {
		this.empcode = empcode;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
