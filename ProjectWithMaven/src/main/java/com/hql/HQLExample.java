package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class HQLExample {
public static void main(String[] args) {
	SessionFactory factory = new Configuration().configure().buildSessionFactory();
	Session s = factory.openSession();
	// HQL
	//Syntex
	//1st way
	//String query = "from Student where city='delhi'";
	// 2 nd way
	String query = "from Student where city=:x";
	Query q=s.createQuery(query);
	q.setParameter("x", "bihar");
	// single result
	//q.uniqueResult(); // give single result 
	// multiple result
	List<Student> list=q.list();
	
	for(Student student : list) {
		System.out.println(student.getName() + " : " + student.getCerti() + " : " + student.getCity());
	}
	
	System.out.println("____________________________________________________________");
	Transaction tx = s.beginTransaction();
	// delete query
			//	Query q2 = s.createQuery("delete from Student s where s.city=:c");
		//	q2.setParameter("c", "delhi");
		//	int r = q2.executeUpdate();
		//	System.out.println("delete");
		//	System.out.println(r);

	// update query 
			Query q2 = s.createQuery("update  Student set city=:c where name=:n");
			q2.setParameter("c", "bihar");
			q2.setParameter("n", "jhon");
			int r = q2.executeUpdate();
			System.out.println("updated");
			System.out.println(r);
			tx.commit();
	// join exeute query
		
	Query q3=s.createQuery("select q.question,q.questionId,a.answer from Question "
			+ "as q Inner join q.answer as a");
	List<Object []> list3 = q3.getResultList();
	 for(Object[] arr : list3) {
		 System.out.println(Arrays.toString(arr));
	 }
					
					
	s.close();
	factory.close();
}
}
