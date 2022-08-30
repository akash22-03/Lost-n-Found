package com.entities;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {
	@Id
	private int id;

	private byte [] adminname;
	private byte [] password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public byte[] getAdminname() {
		return adminname;
	}
	public void setAdminname(byte[] adminname) {
		this.adminname = adminname;
	}
	public byte[] getPassword() {
		return password;
	}
	public void setPassword(byte[] password) {
		this.password = password;
	}
	
	public Admin(byte [] adminname, byte [] password) {
		this.id = new Random().nextInt(100000);
		this.adminname = adminname;
		this.password = password;
	}
	public Admin() {
		super();
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", adminname=" + adminname + ", password=" + password + "]";
	}
	
}
