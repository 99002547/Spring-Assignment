package com.studentapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.studentapp.dao.StudentRepository;
import com.studentapp.exceptions.StudentNotFoundException;
import com.studentapp.model.Student;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public Student getStudentById(Integer id) throws StudentNotFoundException{
		return studentRepository.findById(id)
				.orElseThrow(()->new StudentNotFoundException("Student with specified id not found"));
	}

	@Override
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		Student newStudent=studentRepository.save(student);
		return newStudent;
	}

	@Override
	public Boolean deleteStudent(Integer studentid) throws StudentNotFoundException{
		studentRepository.deleteById(studentid);
		return true;
	}

	@Override
	public List<Student> getStudentsByCity(String city) throws StudentNotFoundException {
		return studentRepository.findByAddressCity(city);
		
	}

	@Override
	public List<Student> getStudentByDepartment(String department) throws StudentNotFoundException {
		return studentRepository.findByDepartment(department);
	}

	@Override
	public List<Student> findStudentByAge(Integer age)throws StudentNotFoundException  {
		return studentRepository.findByAge(age);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

}
