

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



public class client {
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
		client client_1 = new client();
		Stu_Address add1 = new Stu_Address("officers colony","shivaji nagar","HYD","211");
		Student emp1=new Student(1,"ash","bandaru");
		emp1.setAddress(add1);
		client_1.insertData(emp1,add1);
		Stu_Address add2 = new Stu_Address("colony","nagar","NKL","212");
		Student emp2=new Student(2,"ashwitha","aaaaa");
		emp2.setAddress(add2);
		client_1.insertData(emp2,add2);
		client_1.displayRecords();
		
	}
	public void displayRecords() throws InterruptedException {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		List employees=session.createQuery("FROM Student").list();
		for(Iterator it=employees.iterator(); it.hasNext();) {
			Student emp=(Student)it.next();
			System.out.println("rollnum:"+emp.getRollnum());
			System.out.println("FirstName:"+emp.getFirstName());
			System.out.println("last name:"+emp.getLastName());
		
			Stu_Address add=emp.getAddress();
			System.out.println("Address");
			System.out.println("\tstreet" + add.getStreet());
			System.out.println("\tcity"+add.getCity());
			System.out.println("\tstate"+add.getState());
			System.out.println("\tzipcode:"+add.getZipCode());
			
			
		}
		session.close();
	}
	private void insertData(Student empObj, Stu_Address addObj) {
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
