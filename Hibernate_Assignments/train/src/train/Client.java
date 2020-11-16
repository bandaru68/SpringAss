package train;



import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
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
		
		Train in=new Train(1,"Charishma","Bangalore",25);
		client_1.insertData(in);
		Train in1=new Train(2,"kavya","Kolkata",18);
		client_1.insertData(in1);
		Train in2=new Train(3,"vasuu","Delhi",10);
		client_1.insertData(in2);
		Train in3=new Train(4,"rachana","Hyderabad",20);
		client_1.insertData(in3);
		Train in4=new Train(5,"ashwitha","Chennai",22);
		client_1.insertData(in4);
		
		//client_1.displayRecords();
		client_1.DisplayRecords2();
		
	}
	public void displayRecords() throws InterruptedException {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		List employees=session.createQuery("FROM Train").list();
		for(Iterator it=employees.iterator(); it.hasNext();) {
			Train emp=(Train)it.next();
			System.out.println("TrainNo:"+emp.getTrainNo());
			System.out.println("Passenger name:"+emp.getPassName());
			System.out.println("Destination:"+emp.getDestination());
			System.out.println("Age:"+emp.getAge());
			
			
			
		}
		session.close();
	}
	private void insertData(Train empObj) {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(empObj);
		tx.commit();
		System.out.println("Passenger and Train_details are inserted in db");
		session.close();
		
	}
	/* Display based on a criteria*/
	public void DisplayRecords2() throws HibernateException {
		Session session = factory.openSession();
		Criteria cr = session.createCriteria(Train.class);
		
		cr.add(Restrictions.between("age", 20,25));
		List employees = cr.list();
		
		for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
			Train emp = (Train) iterator.next();
			System.out.println("Train Number :"+emp.getTrainNo());
			System.out.println("Passenger Name :"+emp.getPassName());
			System.out.println("Destination :"+emp.getDestination());
			System.out.println("Age :"+emp.getAge());
		}
		
	}


}
