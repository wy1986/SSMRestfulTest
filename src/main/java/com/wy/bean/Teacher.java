package com.wy.bean;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Teacher {
	
	private Integer id;
	@NotBlank
	private String name;
	private String course;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date birth;
	
	public Date getBirth() {
		return birth;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", course=" + course + ", birth=" + birth + "]";
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	
	public Teacher()
	{
		
	}

}
