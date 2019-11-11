package com.wy.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wy.bean.Course;
import com.wy.dao.CourseDao;

@Service
public class CourseDaoImpl implements CourseDao{
	
	@Autowired
	private CourseDao courses;

	@Override
	public ArrayList<Course> getCourses() {
		return courses.getCourses();
	}

}
