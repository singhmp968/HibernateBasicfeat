package com.state;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Certificate;
import com.tut.Student;

public class stateDemo {
public static void main(String[] args) {
	//practice of hibernate object state
	//Transient State
	//Persistent state
	//Detached tate
	//Remove state
	
	SessionFactory f = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	// creating student object
	// tranisient state
	Student student = new Student();
	student.setId(1414);
	student.setName("Peter");
	student.setCity("delhi");
	student.setCerti(new Certificate("java with ds","2 months"));
	// persistant state
	Session s = f.openSession();
Transaction tx = s.beginTransaction();
	s.save(student);
	tx.commit();
	student.setName("jhon "); // work
// detached state
	s.close();
	//student.setName("sachine"); // not work
	
	f.close();
	
}
}
