

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@PrimaryKeyJoinColumn
	private int rollnum;
	private String firstName;
	private String lastName;
	
	
	@OneToOne(targetEntity=Stu_Address.class,cascade=CascadeType.ALL)
	private Stu_Address address;
	
	public Student() {}
	public Student(int rollnum,String fname,String lname) {
		this.rollnum=rollnum;
		this.firstName=fname;
		this.lastName=lname;
		
	}
	public Student(int rollnum,String fname,String lname,int salary ,Stu_Address address ) {
		this.rollnum=rollnum;
		this.firstName=fname;
		this.lastName=lname;
		this.address=address;
		
	}
	public int getRollnum() {
		return rollnum;
	}
	public void setRollnum(int rollnum) {
		this.rollnum=rollnum;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String first_name) {
		this.firstName=first_name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String last_name) {
		this.lastName=last_name;
	}
	
	public Stu_Address getAddress() {
		return address;
	}
	public void setAddress(Stu_Address address ) {
		this.address=address;
	}
}
