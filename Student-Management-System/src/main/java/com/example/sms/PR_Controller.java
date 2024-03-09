package com.example.sms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sms.entity.Student;
import com.example.sms.entity.User;
import com.example.sms.repositories.StudentRepositories;
import com.example.sms.repositories.UserRepositories;

@RestController
@CrossOrigin
public class PR_Controller {

	@Autowired
	StudentRepositories studentRepositories;
	@Autowired
	UserRepositories userRepositories;

	// login --> using request mapping--->
	@RequestMapping("login")
	public int login(@RequestBody String[] cr) {
		String username = cr[0];
		String password = cr[1];

		int cnt = userRepositories.countByUsernameAndPassword(username, password);
		if (cnt == 1)
			return 1;
		return 0;
	}

	// get all students
	@RequestMapping("GetAll")
	public List<Student> getStudent() {
		List<Student> list = studentRepositories.findAll();
		return list;
	}

	// create (post) new student
	@RequestMapping("CreateStudent")
	public Student createStudent(@RequestBody Student student) {
		try {
			return studentRepositories.save(student);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// delete student by id
	@RequestMapping("DeleteStudent{id}")
	public boolean deleteStudent(@PathVariable int id) {
		try {
			studentRepositories.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// get student by course
	@PostMapping("getStudentByCourse")
	public int getStudent(@RequestBody Student request) {
		String course = request.getCourse();
		return studentRepositories.countByCourse(course);
	}

	@RequestMapping("getPassStudent")
	public List<Student> getStudentMarks(@RequestBody int mark) {

		List<Student> student = studentRepositories.findByMarksGreaterThan(mark);
		System.out.println(student);
		return student;
	}

	@RequestMapping("getByName")
	public List<Student> getStudentByName(@RequestBody String name) {
		System.out.println(name);
		List<Student> student = studentRepositories.findByNameStartingWith(name);
		System.out.println(student);
		return student;
	}
}