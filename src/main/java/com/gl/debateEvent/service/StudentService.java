package com.gl.debateEvent.service;
import java.util.List;
import com.gl.debateEvent.entity.Student;


public interface StudentService {

	public List<Student> showAll();
	public void addStudent(Student student);
	public Student findById(Integer id);	
	public void deleteStudentRecord(Student s);
	//Additional Activity
	public List<Student> searchByCountry(String country);
	
}
