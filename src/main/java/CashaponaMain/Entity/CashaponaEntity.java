package CashaponaMain.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="CashaponaDetails")
public class CashaponaEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="Name")
	private String name;
	@Column(name="JobRole")
	private String jobRole;
	@Column(name="Location")
	private String location;
	@Column(name="Salary")
	private int salary;
	
	//Getters and Setter methods
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return jobRole;
	}
	public void setRole(String jobRole) {
		this.jobRole = jobRole;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	//constructor 
	//Default one
	public CashaponaEntity() {
		
	}
	//parameter constructor
	
	
	
	
	
	
}
