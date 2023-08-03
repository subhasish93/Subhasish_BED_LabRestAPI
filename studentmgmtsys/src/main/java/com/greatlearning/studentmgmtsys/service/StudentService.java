package com.greatlearning.studentmgmtsys.service;

import java.util.Set;

import com.greatlearning.studentmgmtsys.model.Student;

public interface StudentService {

	public Set<Student> getAllStudents();
	
	public Student addStudent(Student student);
	
	public Student findStudentById(int id);
	
	public Student updateStudent(int id, Student updateStudent);
	
	public void deleteStudentById(int id);
}