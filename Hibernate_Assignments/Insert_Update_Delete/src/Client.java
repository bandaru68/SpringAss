import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;


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
	public static void main(String[] args) {
		try {
			getSessionFactory();
			Client client_1=new Client();
			/*client_1.insertRecordInDatabase(1,"ash","B",7000);
			client_1.insertRecordInDatabase(2,"ashwitha","A",8000);
			client_1.insertRecordInDatabase(3,"venu","B",9000);
			client_1.insertRecordInDatabase(4,"anu","S",1000);
			client_1.insertRecordInDatabase(5, "cherry", "K", 5000);*/
			/*System.out.println("Listing employees...");
			client_1.DisplayRecords();*/
			/*System.out.println("updated the record..");
			client_1.UpdateRecord(1,90000);
			client_1.DisplayRecords();*/
			/*System.out.println("Displaying data using Native SQL...");
			client_1.DisplayRecords_NativeSQL();*/
			System.out.println("deleted the third record");
			client_1.DeleteRecord(3);
			client_1.DisplayRecords();
		}catch(HibernateException e) {
			System.out.println("exception is" +e);
		}
	}
	public void insertRecordInDatabase(int id, String fname, String lname, int salary)throws HibernateException {
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Employee e1=new Employee(id,fname,lname,salary);
		session.save(e1);
		tx.commit();
		session.close();	
	}
	public void DisplayRecords() throws HibernateException{
		Session session=factory.openSession();
		List empLst=session.createQuery("FROM Employee").list();
		for(Iterator iterator= 
				empLst.iterator(); iterator.hasNext();) {
			Employee emp=(Employee)iterator.next();
			System.out.println("First Name: "+ emp.getFirstName());
			System.out.println("Last Name:" + emp.getLastName());
			System.out.println("Salary:" + emp.getSalary());
			
		}
		session.close();
		
	}
	public void DisplayRecords_NativeSQL()  throws HibernateException {
		Session session=factory.openSession();
		String sql="SELECT * FROM hibernate_create_insert_update_delete where salary>8000 ";
		SQLQuery query=session.createSQLQuery(sql);
		query.addEntity(Employee.class);
		List results=query.list();
		for(Iterator iterator=results.iterator(); iterator.hasNext();) {
			Employee emp=(Employee)iterator.next();
			System.out.println("first name:"+ emp.getFirstName());
			System.out.println("Last Name:" + emp.getLastName());
			System.out.println("Salary:" + emp.getSalary());
			
		}
		session.close();	
	}
	public void UpdateRecord(Integer EmpId,int salary)throws HibernateException{
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Employee employee=(Employee)session.get(Employee.class, EmpId);
		employee.setSalary(salary);
		session.update(employee);
		tx.commit();
		session.close();
		
	}
	public void DeleteRecord(Integer EmployeeID)throws HibernateException{
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Employee employee=(Employee)session.get(Employee.class, EmployeeID);
		session.delete(employee);
		tx.commit();
		session.close();
		
		
	}

}
