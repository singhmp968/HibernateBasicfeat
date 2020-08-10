package com.sqlhql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.tut.Student;

public class NativeSql {
public static void main(String[] args) {
	SessionFactory factory = new Configuration().configure().buildSessionFactory();
	Session s = factory.openSession();
	String q = "select * from student ";	
	NativeQuery nq = 	s.createSQLQuery(q);
	
	List<Object[]> list = nq.list();
	for(Object[] stud : list) {
		//System.out.println(Arrays.deepToString(stud));
	System.out.println(stud[4]  + " : " + stud[3]);
	}
	s.close();
	factory.close();
}
}
