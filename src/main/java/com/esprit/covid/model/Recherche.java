package com.esprit.covid.model;

public class Recherche {
	String spec; 
	String pseudo; 
	String cin; 
	String sex;
	
	public Recherche() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Recherche(String spec, String pseudo, String cin, String sex) {
		super();
		this.spec = spec;
		this.pseudo = pseudo;
		this.cin = cin;
		this.sex = sex;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
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

}
