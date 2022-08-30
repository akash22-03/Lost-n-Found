package com.entities;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="crypto")
public class Crypto 
{
	@Id
	private int id;
	private int Cid;
	private byte [] IVector;
	public int getCid() {
		return Cid;
	}
	public void setCid(int cid) {
		Cid = cid;
	}
	private String secretKey;
	public byte[] getIVector() {
		return IVector;
	}
	public void setIVector(byte[] iVector) {
		IVector = iVector;
	}
	public String getSecretKey() {
		return secretKey;
	}
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	public Crypto(byte[] iVector, String secretKey, int Cid) {
		this.id = new Random().nextInt(100000);
		this.Cid = Cid;
		this.IVector = iVector;
		this.secretKey = secretKey;
	}
	public Crypto() {
		
	}
}
