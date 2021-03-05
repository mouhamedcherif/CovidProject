package com.esprit.covid.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
@Entity
@Table(name="Patient")
public class Patient  implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotEmpty(message = "Nom est obligatoire")
	@Size(min = 2, max = 10, message = "taille de nom doit être entre 2 et 10 caractères")
	@Column(name="nom")
	private String nom;
	
	@NotEmpty(message = "Prenom est obligatoire")
	@Size(min = 2, max = 10, message = "taille de prenom doit être entre 2 et 10 caractères")
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="numcnss")
	private String numcnss;
	

	@Column(name="cin")
	private String cin;
	
	@Column(name="sex")
	private String sex;
	
	
	@Column(name="age")
	private int age;
	
	@Column(name="region")
	private String region;
	
	@JoinColumn(name="ID_User",referencedColumnName="id")
	@ManyToOne(optional=false)
	private User user;
	
	public Patient() {
		super();
		this.user = new User();
		// TODO Auto-generated constructor stub
	}

	public Patient(String nom,String prenom,String numcnss, String cin, String sex, int age, String region, User user) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.numcnss = numcnss;
		this.cin = cin;
		this.sex = sex;
		this.age = age;
		this.region = region;
		this.user = user;
	}

	public Patient( String numcnss, String cin, String sex, int age, String region) {
		super();
		this.numcnss = numcnss;
		this.cin = cin;
		this.sex = sex;
		this.age = age;
		this.region = region;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNumcnss() {
		return numcnss;
	}

	public void setNumcnss(String numcnss) {
		this.numcnss = numcnss;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((cin == null) ? 0 : cin.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((numcnss == null) ? 0 : numcnss.hashCode());
		result = prime * result + ((region == null) ? 0 : region.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		if (age != other.age)
			return false;
		if (cin == null) {
			if (other.cin != null)
				return false;
		} else if (!cin.equals(other.cin))
			return false;
		if (id != other.id)
			return false;
		if (numcnss == null) {
			if (other.numcnss != null)
				return false;
		} else if (!numcnss.equals(other.numcnss))
			return false;
		if (region == null) {
			if (other.region != null)
				return false;
		} else if (!region.equals(other.region))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		return true;
	}
	
}
