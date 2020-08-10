package com.tut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project started" );
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
    
//    Configuration cfg = new Configuration();
//    cfg.configure("hibernate.cfg.xml");
//    SessionFactory factory = cfg.buildSessionFactory();
//  System.out.println(factory);
//System.out.println(factory.isClosed());
    
    Student st = new Student();
    st.setId(101);
    st.setName("JHON");
    st.setCity("DELHI");
    System.out.println(st);
    
//    Session session = factory.getCurrentSession();
    
    // Creating object of address class
    
    Address ad=new Address();
    ad.setStreet("stree1");
    ad.setCity("delhi");
    ad.setOpen(true);
    ad.setAddedDate(new Date());
    ad.setX(123.145);
    
    //Reading image
    FileInputStream fis = new FileInputStream("src/main/java/pic.png");
    
    byte[] data = new byte[fis.available()];
    fis.read(data);
    ad.setImage(data);
    
    Session session = factory.openSession();
    //session.beginTransaction();
   
    org.hibernate.Transaction tx= session.beginTransaction();
    
    session.save(st);
    session.save(ad);
    //session.getTransaction().commit();
    tx.commit();
    session.close();
    System.out.println("done");
    }
}
