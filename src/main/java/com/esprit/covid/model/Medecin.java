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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name="Medecin")
public class Medecin extends User implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="sepc")
	private String sepc;
	

	@Column(name="sex")
	private String sex;
	
	@Column(name="cin")
	private String cin;
	
	//@JsonManagedReference
	@OneToMany(mappedBy="medecin",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Hopital> Hopitals;


	public Medecin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Medecin(long id,
			String nom,
			String prenom,
			String email, String mdp) {
		super(id, nom, prenom, email, mdp);
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
