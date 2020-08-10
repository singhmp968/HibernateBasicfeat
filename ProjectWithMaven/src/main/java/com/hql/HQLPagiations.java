package com.hql;

import org.hibernate.query.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class HQLPagiations {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
//		Query<Student> query = s.createQuery("from Student",Student.class);
		Query query = s.createQuery("from Student");
		// implementing pegenations
		query.setFirstResult(0);
		query.setMaxResults(5);
		List<Student> list = query.list();
		for(Student st:list) {
			System.out.println(st.getId() + " " + st.getName() + " : " + st.getCity());
		}
		
		
		s.close();
	factory.close();
	}	
}
