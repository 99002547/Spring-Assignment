package com.studentapp.service;

import java.util.List;


import com.studentapp.exceptions.StudentNotFoundException;
import com.studentapp.model.Student;

public interface StudentService {
Student getStudentById(Integer id)throws StudentNotFoundException ;
Student addStudent(Student student);
Boolean deleteStudent(Integer id)throws StudentNotFoundException ;
List<Student> getAllStudents();
List<Student> getStudentsByCity(String city)throws StudentNotFoundException ;
List<Student> getStudentByDepartment(String department)throws StudentNotFoundException ;
List<Student> findStudentByAge(Integer age)throws StudentNotFoundException ;
}
