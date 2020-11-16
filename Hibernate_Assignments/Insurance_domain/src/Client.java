

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



public class Client {
	private static SessionFactory factory;

	public static void getSessionFactory() {
		try {
			Configuration configuration = new Configuration().configure();
	        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	        factory = configuration.buildSessionFactory(serviceRegistry);		
		}catch(Throwable ex) {
			System.err.println("Failed to create sessionFactory object" +ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	public static void main(String[] args) throws InterruptedException {
		getSessionFactory();
		Client client_1 = new Client();
		
		Insurance in=new Insurance(1,"ashwitha",2,10000);
		client_1.insertData(in);
		Insurance in1=new Insurance(2,"ash",4,100000);
		client_1.insertData(in1);
		client_1.displayRecords();
		
	}
	public void displayRecords() throws InterruptedException {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		List employees=session.createQuery("FROM Insurance").list();
		for(Iterator it=employees.iterator(); it.hasNext();) {
			Insurance emp=(Insurance)it.next();
			System.out.println("Policy:"+emp.getPolicy());
			System.out.println("name:"+emp.getName());
			System.out.println("amount:"+emp.getAmount());
			System.out.println("tenure:"+emp.getTenure());
			
			
			
		}
		session.close();
	}
	private void insertData(Insurance empObj) {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(empObj);
		tx.commit();
		System.out.println("Employee and address are inserted in db");
		session.close();
		
	}

}
