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

import oracle.net.TNSAddress.Address;


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
			Set<Student> vmg = new HashSet<Student>();
			Set<Student> cb = new HashSet<Student>();
			Set<Student> mv = new HashSet<Student>();
			Set<Student> km = new HashSet<Student>();
			vmg.add(new Student(1268, "Ashwitha B"));
			vmg.add(new Student(1267, "Rohith T"));
			cb.add(new Student(1269, "Avinash k"));
			mv.add(new Student(1270, "Dinesh s"));
			km.add(new Student(1264, "Dhoni"));
			km.add(new Student(1265, "chandler S"));
			cb.add(new Student(1260, "joey G"));
			mv.add(new Student(1261, "venu"));

			College vmeg = new College("VMEG", "Vardhaman College Of Engineering",vmg);
			College cbit = new College("CBIT", "Chaitanya Bharathi College Of Engineering",cb);
			College mvsr = new College("MVSR", "MVSR College Of Engineering",mv);
			College kmit = new College("KMIT", "Keshav Memorial Institute Of Tech.",km);

			session.save(vmeg);
			session.save(cbit);
			session.save(mvsr);
			session.save(kmit);
			tx.commit();
			c.displayRecords();
			
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void displayRecords() throws HibernateException{
		Session session = factory.openSession();

		List stdList = session.createQuery("From Student_clg").list();
		display(stdList);
		List clgList = session.createQuery("From College").list();
		display(clgList);
		List clgstd = session.createQuery("From clgstu").list();
		display(clgstd);
		session.close();
	}
	
	public void display(List obj) {
		for(Iterator iterator = obj.iterator(); iterator.hasNext();) {
			College clg = (College) iterator.next();
			System.out.println(clg.toString());
		}
	}
	
	
}
