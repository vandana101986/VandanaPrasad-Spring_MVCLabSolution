package com.gl.debateEvent.service;

import java.util.List;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import com.gl.debateEvent.entity.Student;

@Repository
public class ServiceImplementation implements StudentService 
{	
	private SessionFactory sessionFactory;
	private Session session;
	
	public ServiceImplementation(SessionFactory sessionFac) 
	{
		this.sessionFactory=sessionFac;
		
		try 
		{
			//if there is no session already created, it throws an Exception
			session=this.sessionFactory.getCurrentSession();
		}
		catch(HibernateException e) 
		{
			//create/open the session
			session=this.sessionFactory.openSession();
		}
	}

	//spring transactional method-either the method succeeds or rollsback
	
	//Show all Students
	@Override
	@Transactional
	public List<Student> showAll() 
	{
		List<Student> studList=session.createQuery("from Student").list();
		/*for(Student s:studList) {
			System.out.println(s);
		}*/
		return studList;
	}
	
	//Add a student record
	@Transactional
	public void addStudent(Student student) 
	{
		Transaction tr=session.beginTransaction();
		session.saveOrUpdate(student);//save new record and update an existing record
		tr.commit();
	}

	//find a student by id->used for editing student record
	@Transactional
	public Student findById(Integer id)
	{
		Student stud=session.get(Student.class,id);
		return stud;		
	}
	
	//delete a student's record
	@Override
	@Transactional
	public void deleteStudentRecord(Student s) {
		Transaction tr=session.beginTransaction();
		session.delete(s);		
		tr.commit();		
	}
	
	//Additional activity
	//search student by country
	@Override
	@Transactional
	public List<Student> searchByCountry(String country) {
		List<Student> studList = null;
		String query;
		
		if(country.length() != 0)
		{
			query="from Student where country like '%"+country+"%'";
		}
		else
		{
			query="from Student";
		}
		
		studList=session.createQuery(query).list();
		return studList;		
	}
}
