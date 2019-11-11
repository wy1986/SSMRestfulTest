package com.wy.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wy.bean.Course;
import com.wy.bean.Teacher;
import com.wy.service.CourseDaoImpl;
import com.wy.service.TeacherDaoImpl;

@RestController
public class TeacherController {

	@Autowired
	private TeacherDaoImpl teacherDaoImpl;
	@Autowired
	private CourseDaoImpl courseDaoImpl;

	@RequestMapping("/getTeacher")
	public String getTeacher(@RequestParam("id") int id, Model model) {
		Teacher teacher = teacherDaoImpl.getTeacherById(id);
		model.addAttribute("teacher", teacher);
		System.out.println(teacher);
		return "success";
	}

	@RequestMapping("/getTeachers")
	public String getTeachers(Model model) {
		ArrayList<Teacher> teachers = teacherDaoImpl.getTeachers();
		model.addAttribute("teachers", teachers);
		return "showTeachers";
	}

	@GetMapping("/teachers")
	public Teacher getTeacherById(@RequestParam("id") Integer id)
	{
		Teacher teacher = teacherDaoImpl.getTeacherById(id);
		return teacher;
	}
	
	@PostMapping("/teachers")
	public Teacher addTeacher(Teacher teacher)
	{
		System.out.println(teacher);
		return teacher;
	}
	
	@RequestMapping(value = "/teacher",method = RequestMethod.GET)
	public String teacher(Model model) {
		ArrayList<Course> courses = new ArrayList<Course>();
		courses = courseDaoImpl.getCourses();
		model.addAttribute("courses", courses);
		model.addAttribute("teacher", new Teacher());
		return "addTeacher";
	}
	
	@RequestMapping(value = "/teacher", method = RequestMethod.POST)
	//public String addOrUpdateTeacher(@RequestParam("id") String id,@Valid @RequestParam("name") String name,BindingResult result,@RequestParam("course") String course,@RequestParam("birth") Date birth) {
	public String addOrUpdateTeacher(@Valid Teacher teacher,BindingResult result,ModelMap modelMap) {	
	//Teacher teacher = new Teacher();
		//if (teacher.getId().equals("")) {
		if (!result.hasErrors()) {
			if (teacher.getId() == null) {
				// teacher.setName(name);
				// teacher.setCourse(course);
				// teacher.setBirth(birth);
				teacherDaoImpl.addTeacher(teacher);
			} else {
				// teacher.setId(Integer.parseInt(id));
				// teacher.setCourse(course);
				// teacher.setName(name);
				// teacher.setBirth(birth);
				teacherDaoImpl.updateTeacher(teacher);
			}
			return "redirect:/getTeachers";
		}
		else {
			ArrayList<Course> courses = new ArrayList<Course>();
			courses = courseDaoImpl.getCourses();
			modelMap.addAttribute("courses", courses);
			return "addTeacher";
		}
	}
	
	@RequestMapping(value="teacher/{id}",method = RequestMethod.GET)
	public String updateTeacher(@PathVariable("id")Integer id,Model model)
	{
		Teacher teacher = teacherDaoImpl.getTeacherById(id);
		model.addAttribute("teacher", teacher);
		ArrayList<Course> courses = new ArrayList<Course>();
		courses = courseDaoImpl.getCourses();
		model.addAttribute("courses", courses);
		return "addTeacher";
	}
	
	@RequestMapping(value="teacher/{id}",method=RequestMethod.DELETE)
	public String deleteTeacher(@PathVariable("id")Integer id)
	{
		teacherDaoImpl.deleteTeacher(id);
		return "redirect:/getTeachers";
	}
	
	@RequestMapping(value="dynamicSelect")
	//public String dynamicSelect(Teacher teacher,Model model)
	public String dynamicSelect(Model model)
	{
		Teacher teacher = new Teacher();
		//teacher.setId(2);
		teacher.setCourse("Chinese");
		teacher.setName("王3");
		ArrayList<String> selectedItems = new ArrayList<String>();
		//selectedItems.add("course");
		selectedItems.add("name");
		selectedItems.add("id");
		ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
		teacherList = teacherDaoImpl.dynamicSelect(selectedItems,teacher);
		model.addAttribute("teacherList", teacherList);
		
		return "showSelectedTeachers";
	}

}
