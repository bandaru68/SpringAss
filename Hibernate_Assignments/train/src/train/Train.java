package train;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TRAIN_RESERVATION")
public class Train implements Serializable 
{
 @Id
 @Column(name="TRAINNO")
 @GeneratedValue
 private int trainno;
 @Column(name="PASSENGERNAME")
 private String passname;
 @Column(name="DESTINATION")
 private String destination;
 @Column(name="AGE")
 private int age;
 
 public Train() {}
 public Train(int trainno,String passname,String destination,int age) {
	 this.trainno=trainno;
	 this.passname=passname;
	 this.destination=destination;
	 this.age=age;
 }
 public int getTrainNo() {
  return trainno;
 }
 public void setTrainNo(int trainno) {
  this.trainno=trainno;
 }
 public String getPassName() {
  return passname;
 }
 public void setPassName(String passname) {
  this.passname = passname;
 }
 public String getDestination() {
  return destination;
 }
 public void setDestination(String destination) {
  this.destination = destination;
 }
 public int getAge() {
  return age;
 }
 public void setAge(int age) {
  this.age = age;
 }
}