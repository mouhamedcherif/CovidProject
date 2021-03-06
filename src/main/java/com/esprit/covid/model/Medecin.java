package com.esprit.covid.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name="Medecin")
public class Medecin  implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="sepc")
	private String sepc;
	

	@Column(name="sex")
	private String sex;
	
	@Column(name="cin")
	private String cin;
	
	@NotEmpty(message = "Nom est obligatoire")
	@Size(min = 2, max = 10, message = "taille de nom doit être entre 2 et 10 caractères")
	@Column(name="nom")
	private String nom;
	
	@NotEmpty(message = "Prenom est obligatoire")
	@Size(min = 2, max = 10, message = "taille de prenom doit être entre 2 et 10 caractères")
	@Column(name="prenom")
	private String prenom;
	
	//@JsonManagedReference
	@OneToMany(mappedBy="medecin",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Hopital> Hopitals;

	@JoinColumn(name="ID_User",referencedColumnName="id")
	@ManyToOne(optional=false)
	private User user;
	
	public Medecin() {
		super();
		this.user = new User();

		// TODO Auto-generated constructor stub
	}


	public Medecin(String sepc, String sex, String cin,String nom, String prenom,User user) {
		super();
		this.sepc = sepc;
		this.sex = sex;
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.user = user;
	}


	public Medecin( String sepc, String sex, String cin,String nom,String prenom) {
		super();
		this.sepc = sepc;
		this.sex = sex;
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
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


	public String getSepc() {
		return sepc;
	}

	public void setSepc(String sepc) {
		this.sepc = sepc;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}



	public List<Hopital> getHopitals() {
		return Hopitals;
	}

	public void setHopitals(List<Hopital> hopitals) {
		Hopitals = hopitals;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cin == null) ? 0 : cin.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((Hopitals == null) ? 0 : Hopitals.hashCode());
		result = prime * result + ((sepc == null) ? 0 : sepc.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medecin other = (Medecin) obj;
		if (cin == null) {
			if (other.cin != null)
				return false;
		} else if (!cin.equals(other.cin))
			return false;
		if (id != other.id)
			return false;
		if (Hopitals == null) {
			if (other.Hopitals != null)
				return false;
		} else if (!Hopitals.equals(other.Hopitals))
			return false;
		if (sepc == null) {
			if (other.sepc != null)
				return false;
		} else if (!sepc.equals(other.sepc))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		return true;
	}
	
}
