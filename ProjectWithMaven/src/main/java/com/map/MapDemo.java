package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
public static void main(String[] args) {
	SessionFactory factory = new Configuration().configure().buildSessionFactory();

	// creating question
	
	Question q1 = new Question();
	q1.setQuestionId(1212);
	q1.setQuestion("what is java");
	
	//creating answer
	
	Answer answer = new Answer();
	answer.setAnswerId(343);
	answer.setAnswer("java is pro lang");
	answer.setQuestion(q1);
	
	Answer answer1 = new Answer();
	answer1.setAnswerId(343);
	answer1.setAnswer("ghf dyt ytf yd trd");
	answer1.setQuestion(q1);

	Answer answer2 = new Answer();
	answer2.setAnswerId(343);
	answer2.setAnswer("ghf dyt ytf yd trd");
	answer2.setQuestion(q1);

	List<Answer> li =new ArrayList<Answer>();
li.add(answer);
	li.add(answer1);
	li.add(answer2);
	
	q1.setAnswer(li);
	//session
	Session s = factory.openSession();
	Transaction tx = s.beginTransaction();
	
	
//	s.save(q1);
//	s.save(answer);
//	s.save(answer1);
//	//s.save(answer2);
	
	Question q = (Question)s.get(Question.class,1212);
	System.out.println(q.getQuestionId());
	System.out.println(q.getQuestion());
	System.out.println(q.getAnswer().size());
	tx.commit();
	s.close(); 
	
factory.close();
}
}
