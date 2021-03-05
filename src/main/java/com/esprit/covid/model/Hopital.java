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

@Entity
@Table(name="Hopital")
public class Hopital  implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="dateRv")
	private String dateRv;
	

	@Column(name="nomHopital")
	private String nomHopital;
	
	@Column(name="gouvernerat")
	private String gouvernerat;
	
	@Column(name="etatest")
	private int etatest;
	//@JsonBackReference
	@JoinColumn(name="ID_Medecin",referencedColumnName="id")
	@ManyToOne(optional=false)
	private Medecin medecin;
	
	//@JsonBackReference
	@JoinColumn(name="ID_Patient",referencedColumnName="id")
	@ManyToOne(optional=false)
	private Patient patient;

	public Hopital() {
		super();
		this.medecin = new Medecin();
		this.patient = new Patient();
	}

	public Hopital( String dateRv, String nomHopital, String gouvernerat, int etatest, Medecin medecin,
			Patient patient) {
		super();
		this.id = id;
		this.dateRv = dateRv;
		this.nomHopital = nomHopital;
		this.gouvernerat = gouvernerat;
		this.etatest = etatest;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDateRv() {
		return dateRv;
	}

	public void setDateRv(String dateRv) {
		this.dateRv = dateRv;
	}

	public String getNomHopital() {
		return nomHopital;
	}

	public void setNomHopital(String nomHopital) {
		this.nomHopital = nomHopital;
	}

	public String getGouvernerat() {
		return gouvernerat;
	}

	public void setGouvernerat(String gouvernerat) {
		this.gouvernerat = gouvernerat;
	}

	public int getEtatest() {
		return etatest;
	}

	public void setEtatest(int etatest) {
		this.etatest = etatest;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dateRv == null) ? 0 : dateRv.hashCode());
		result = prime * result + etatest;
		result = prime * result + ((gouvernerat == null) ? 0 : gouvernerat.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nomHopital == null) ? 0 : nomHopital.hashCode());
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
		Hopital other = (Hopital) obj;
		if (dateRv == null) {
			if (other.dateRv != null)
				return false;
		} else if (!dateRv.equals(other.dateRv))
			return false;
		if (etatest != other.etatest)
			return false;
		if (gouvernerat == null) {
			if (other.gouvernerat != null)
				return false;
		} else if (!gouvernerat.equals(other.gouvernerat))
			return false;
		if (id != other.id)
			return false;
		if (nomHopital == null) {
			if (other.nomHopital != null)
				return false;
		} else if (!nomHopital.equals(other.nomHopital))
			return false;
		return true;
	}


	
}
