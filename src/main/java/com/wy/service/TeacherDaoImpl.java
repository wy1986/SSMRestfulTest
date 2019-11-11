package com.wy.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wy.bean.Teacher;
import com.wy.dao.TeacherDao;

@Service
public class TeacherDaoImpl implements TeacherDao {
	
	@Autowired
	private TeacherDao teacherDao;

	@Override
	public Teacher getTeacherById(Integer id) {
		// TODO Auto-generated method stub
		return teacherDao.getTeacherById(id);
	}

	@Override
	public ArrayList<Teacher> getTeachers() {
		// TODO Auto-generated method stub
		return teacherDao.getTeachers();
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
	public void addTeacher(Teacher teacher) {
		
		teacherDao.addTeacher(teacher);
		//int i = 10/0;
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		teacherDao.updateTeacher(teacher);
	}

	@Override
	public void deleteTeacher(Integer id) {

		teacherDao.deleteTeacher(id);
		
	}

	@Override
	public ArrayList<Teacher> dynamicSelect(ArrayList<String> selectedItems,Teacher teacher) {
		// TODO Auto-generated method stub
		return teacherDao.dynamicSelect(selectedItems,teacher);
	}
}
