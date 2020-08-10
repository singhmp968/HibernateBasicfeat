package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
public static void main(String[] args) {
	SessionFactory factory = new Configuration().configure().buildSessionFactory();

	Session session = factory.openSession();
	//get - student 
//Student student	=(Student)session.get(Student.class, 101);
Student student	=(Student)session.load(Student.class, 101);
	System.out.println(student);
Address adress = (Address)session.get(Address.class, 1);	
	System.out.println(adress.getStreet()+" : " + adress.getCity());
	session.close();
factory.close();
}
}
