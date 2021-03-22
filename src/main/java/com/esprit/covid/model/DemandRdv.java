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

import org.springframework.lang.Nullable;
@Entity
@Table(name="DemandRdv")
public class DemandRdv implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="etat")
	private int etat;
	
	@JoinColumn(name="ID_Medecin",referencedColumnName="id")
	@ManyToOne(optional=false)
	@Nullable
	public Medecin medecin;
	
	
	//@JsonBackReference
	@JoinColumn(name="ID_Patient",referencedColumnName="id")
	@ManyToOne( optional=false)
	
	public Patient patient;
	
	@JoinColumn(name="ID_hopital",referencedColumnName="id")
	@ManyToOne( optional=false)
	@Nullable
	public Hopital hopital;

	public DemandRdv() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DemandRdv(int etat) {
		super();
		this.etat = etat;
	}

	public DemandRdv(long id, int etat, Medecin medecin, Patient patient, Hopital hopital) {
		super();
		this.id = id;
		this.etat = etat;
		this.medecin = medecin;
		this.patient = patient;
		this.hopital = hopital;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
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

	public Hopital getHopital() {
		return hopital;
	}

	public void setHopital(Hopital hopital) {
		this.hopital = hopital;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + etat;
		result = prime * result + ((hopital == null) ? 0 : hopital.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((medecin == null) ? 0 : medecin.hashCode());
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
		DemandRdv other = (DemandRdv) obj;
		if (etat != other.etat)
			return false;
		if (hopital == null) {
			if (other.hopital != null)
				return false;
		} else if (!hopital.equals(other.hopital))
			return false;
		if (id != other.id)
			return false;
		if (medecin == null) {
			if (other.medecin != null)
				return false;
		} else if (!medecin.equals(other.medecin))
			return false;
		if (patient == null) {
			if (other.patient != null)
				return false;
		} else if (!patient.equals(other.patient))
			return false;
		return true;
	}
	
}
