

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="INSURANCE")
public class Insurance implements Serializable 
{
 @Id
 @Column(name="POLICYNO")
 @GeneratedValue
 private int policyno;
 @Column(name="NAME")
 private String name;
 @Column(name="TENURE")
 private int tenure;
 @Column(name="AMOUNT")
 private int amount;
 
 public Insurance() {}
 public Insurance(int policyno,String name,int tenure,int amount) {
	 this.policyno=policyno;
	 this.name=name;
	 this.tenure=tenure;
	 this.amount=amount;
 }
 public int getPolicy() {
  return policyno;
 }
 public void setPolicy(int policyno) {
  this.policyno = policyno;
 }
 public String getName() {
  return name;
 }
 public void setName(String name) {
  this.name = name;
 }
 public int getTenure() {
  return tenure;
 }
 public void setTenure(int tenure) {
  this.tenure = tenure;
 }
 public int getAmount() {
  return amount;
 }
 public void setCourse(String amout) {
  this.amount = amount;
 }
}