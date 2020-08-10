package com.tut;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
	
	Student studebt1 = new Student();
	studebt1.setId(1452);
	studebt1.setName("Ankit Tiwari");
	studebt1.setCity("Lokesh");
	
	Certificate certificate = new Certificate();
	certificate.setCourse("Android");
	certificate.setDuration("2 months");
	
	studebt1.setCerti(certificate);
	
	
	
	Student studebt2 = new Student();
	studebt2.setId(14);
	studebt2.setName("ravi Tiwari");
	studebt2.setCity("Lok");
	
	Certificate certificate2 = new Certificate();
	certificate2.setCourse("web development");
	certificate2.setDuration("3 months");
	
	studebt2.setCerti(certificate2);
	Session s = factory.openSession();
	
	org.hibernate.Transaction tx =s.beginTransaction();
	
	s.save(studebt1);
	s.save(studebt2);
	tx.commit();
	s.close();
	factory.close();
	
	}
	
}
