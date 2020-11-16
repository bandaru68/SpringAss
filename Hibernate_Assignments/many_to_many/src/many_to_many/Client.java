package many_to_many;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class Client {
	
	private static SessionFactory factory;
	
	public static void getSessionFactory() {
		
		try {
			Configuration conf = new Configuration().configure();
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
			factory = conf.buildSessionFactory(builder.build());
		}
		
		catch(Throwable ex) {
			System.err.println("Failed to create Session Factory Object "+ex);	
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static void main(String args[]) {
		try
		{
			getSessionFactory();
			Client c = new Client();
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();

			Student ash = new Student(259, "Ashwitha");
			Student cha = new Student(224, "charishma");
			Student v = new Student(208, "Venu");
			Student a = new Student(232, "Anu");
			
			Set<Student> shift1 = new HashSet<Student>();
			shift1.add(cha);
			shift1.add(v);
			
			Set<Student> shift2 = new HashSet<Student>();
			shift2.add(ash);
			shift2.add(a);
						
			Teacher john = new Teacher(1, "C", "John", shift2);
			Teacher m = new Teacher(2, "Java", "Monica", shift1);
			Teacher r = new Teacher(3, "Angular", "Ross", shift1);
			Teacher p = new Teacher(4, "Git", "phoebe", shift2);

			session.save(john);
			session.save(m);
			session.save(r);
			session.save(p);
			
			tx.commit();
			c.displayRecords();
			
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void displayRecords() throws HibernateException{
		Session session = factory.openSession();
		List tchList = session.createQuery("From Teacher_many").list();
		display(tchList);
		session.close();
	}
	
	public void display(List obj) {
		for(Iterator iterator = obj.iterator(); iterator.hasNext();) {
			Teacher clg = (Teacher) iterator.next();
			System.out.println("Students studying under "+clg.getName()+":\n");
			Set<Student> std = clg.getStd();
			Iterator it = std.iterator();
			while(it.hasNext()) {
				System.out.println(it.next().toString());
			}
		}
	}
	
	
}
