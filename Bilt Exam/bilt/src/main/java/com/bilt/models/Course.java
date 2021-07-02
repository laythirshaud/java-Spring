package com.bilt.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name="courses")
public class Course {
	@Id
    @GeneratedValue()
    private Long id;
    // NEW
	@Size(min=3,message="Name must be more than 3 characters!")
	private String name;
	@Size(min=3,message="Name must be more than 3 character!")
	private String instructor;
	@Min(value=0 ,message="capacity must be more than one !")
    private Integer capacity;
	
	@ManyToMany(fetch = FetchType.LAZY)
	 @JoinTable(
	     name = "users_courses", 
	     joinColumns = @JoinColumn(name = "course_id"), 
	     inverseJoinColumns = @JoinColumn(name = "users_id")
	 )
	private List<User> users;
	 public List<User> getUsers() {
	 	 return users;
	 }
	 
	 
	public Course() {

	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getInstructor() {
		return instructor;
	}


	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}


	public Integer getCapacity() {
		return capacity;
	}


	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}
	 
	 

}
