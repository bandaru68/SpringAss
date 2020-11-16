package one_to_one;

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
		Address add1 = new Address("officers colony","shivaji nagar","HYD","211");
		Employee emp1=new Employee(1,"ash","bandaru",7000);
		emp1.setAddress(add1);
		client_1.insertData(emp1,add1);
		Address add2 = new Address("colony","nagar","NKL","212");
		Employee emp2=new Employee(2,"ashwitha","aaaaa",800);
		emp2.setAddress(add2);
		client_1.insertData(emp2,add2);
		client_1.displayRecords();
		
	}
	public void displayRecords() throws InterruptedException {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		List employees=session.createQuery("FROM Employee").list();
		for(Iterator it=employees.iterator(); it.hasNext();) {
			Employee emp=(Employee)it.next();
			System.out.println("FirstName:"+emp.getFirstName());
			System.out.println("last name:"+emp.getLastName());
			System.out.println("saalry:"+emp.getSalary());
			Address add=emp.getAddress();
			System.out.println("Address");
			System.out.println("\tstreet" + add.getStreet());
			System.out.println("\tcity"+add.getCity());
			System.out.println("\tstate"+add.getState());
			System.out.println("\tzipcode:"+add.getZipCode());
			
			
		}
		session.close();
	}
	private void insertData(Employee empObj, Address addObj) {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(empObj);
		session.save(addObj);
		tx.commit();
		System.out.println("Employee and address are inserted in db");
		session.close();
		
	}

}
