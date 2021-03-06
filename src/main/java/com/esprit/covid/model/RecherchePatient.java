package com.esprit.covid.model;

public class RecherchePatient {
	String pseudo; 
	String cin; 
	String sex;
	String region;
	public RecherchePatient() {
		super();
	}
	public RecherchePatient(String pseudo, String cin, String sex, String region) {
		super();
		this.pseudo = pseudo;
		this.cin = cin;
		this.sex = sex;
		this.region = region;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
}
