package com.muthu.news;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@Column(name="mob")
	private String mob;
	
	@Column(name="reg")
	private String reg;
	
	@Column(name="name")
	private String name;
	
	@Column(name="status")
	private String status;
	
	@Column(name="papers")
	private String papers;
	
	@Column(name="bill")
	private Double bill;

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

	public String getReg() {
		return reg;
	}

	public void setReg(String reg) {
		this.reg = reg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPapers() {
		return papers;
	}

	public void setPapers(String papers) {
		this.papers = papers;
	}

	public Double getBill() {
		return bill;
	}

	public void setBill(Double bill) {
		this.bill = bill;
	}
	
	public User() {
		
	}

	public User(String mob, String reg, String name, String status, String papers, Double bill) {
		super();
		this.mob = mob;
		this.reg = reg;
		this.name = name;
		this.status = status;
		this.papers = papers;
		this.bill = bill;
	}

	@Override
	public String toString() {
		return "[கைபேசி எண்: " + mob + ", "
				+ "பகுதி: " + reg + ", "
				+ "பெயர்: " + name + ", "
				+ "பில் நிலை: " + status + ", "
				+ "செய்தி தாள்கள்: " + papers
				+ ", பில் மதிப்பு: " + bill + "]";
	}
	
	

}
