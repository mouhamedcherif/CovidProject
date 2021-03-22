package com.esprit.covid.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	public Medecin medecin;
	
	//@JsonBackReference
	@JoinColumn(name="ID_Patient",referencedColumnName="id")
	@ManyToOne( optional=false)
	public Patient patient;

	public Hopital() {
		super();
	}



	public Hopital( String dateRv, String nomHopital, String gouvernerat, int etatest) {
		super();
		this.id = id;
		this.dateRv = dateRv;
		this.nomHopital = nomHopital;
		this.gouvernerat = gouvernerat;
		this.etatest = etatest;

	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
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
		int result = 1;
		result = prime * result + ((dateRv == null) ? 0 : dateRv.hashCode());
		result = prime * result + etatest;
		result = prime * result + ((gouvernerat == null) ? 0 : gouvernerat.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((medecin == null) ? 0 : medecin.hashCode());
		result = prime * result + ((nomHopital == null) ? 0 : nomHopital.hashCode());
		result = prime * result + ((patient == null) ? 0 : patient.hashCode());
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
		if (medecin == null) {
			if (other.medecin != null)
				return false;
		} else if (!medecin.equals(other.medecin))
			return false;
		if (nomHopital == null) {
			if (other.nomHopital != null)
				return false;
		} else if (!nomHopital.equals(other.nomHopital))
			return false;
		if (patient == null) {
			if (other.patient != null)
				return false;
		} else if (!patient.equals(other.patient))
			return false;
		return true;
	}

	


	
}
