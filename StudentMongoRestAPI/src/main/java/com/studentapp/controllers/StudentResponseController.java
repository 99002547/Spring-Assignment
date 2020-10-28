package com.studentapp.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentapp.exceptions.StudentNotFoundException;
import com.studentapp.model.Student;
import com.studentapp.service.StudentService;

@RestController
@RequestMapping("/student-api")
public class StudentResponseController {

	@Autowired
	StudentService studentService;
	@PostMapping("/students")
	 ResponseEntity<Student> addStudent(@RequestBody Student student)
	 {
		Student nStudent=studentService.addStudent(student);
		return ResponseEntity.ok(nStudent);
	 }
	@DeleteMapping("/students/delete-one/{studentId}")
	ResponseEntity<Void> deleteStudent(@PathVariable("studentId")  Integer studentid) throws StudentNotFoundException
	 {
		 studentService.deleteStudent(studentid);
		 return ResponseEntity.status(HttpStatus.OK).build();
	 }
	@GetMapping("/students/get-one/{studentId}")
	ResponseEntity<Student> getStudentById(@PathVariable("studentId") Integer studentid) throws StudentNotFoundException
	 {
		Student nStudent=studentService.getStudentById(studentid);
		HttpHeaders header=new HttpHeaders();
		header.add("desc", "Getting Student By Id");
		header.add("title", "One Student");
		return ResponseEntity.status(HttpStatus.OK).headers(header).body(nStudent);
	 }
	
	 @GetMapping("/students")
	 ResponseEntity<List<Student>> getAllStudents()
	 {
		 List<Student> studentList=studentService.getAllStudents();
		 return ResponseEntity.ok(studentList);
	 }
	 @GetMapping("/students/department/{department}")
	 ResponseEntity<List<Student>> getStudentbyDepartment(@PathVariable("department")String department) throws StudentNotFoundException{
	        List<Student> StudentList =   studentService.getStudentByDepartment(department);
	        return ResponseEntity.ok(StudentList);
	    }
	 @GetMapping("/students/age/{age}")
	 ResponseEntity<List<Student>> getStudentbyAge(@PathVariable("age")Integer age)throws StudentNotFoundException{
	        List<Student> studentList = studentService.findStudentByAge(age);    
	        return ResponseEntity.ok(studentList);
	    }
	@GetMapping("/students/address/{city}")
	 public ResponseEntity<List<Student>> findAddreesByCity(@PathVariable("city")String city) {
	        List<Student> StudentList = studentService.getStudentsByCity(city);
	        return ResponseEntity.ok(StudentList);
	        
	    }
}
