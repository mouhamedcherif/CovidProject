package com.esprit.covid.model;

public class RechercheRendv {
	
String DateRv;
String Etatest;
String Gouvernerat;
String NomHopital;
String nomedecin;
String nompatient;
public RechercheRendv() {
	super();
	// TODO Auto-generated constructor stub
}
public RechercheRendv(String dateRv, String etatest, String gouvernerat, String nomHopital, String nomedecin,
		String nompatient) {
	super();
	DateRv = dateRv;
	Etatest = etatest;
	Gouvernerat = gouvernerat;
	NomHopital = nomHopital;
	this.nomedecin = nomedecin;
	this.nompatient = nompatient;
}
public String getDateRv() {
	return DateRv;
}
public void setDateRv(String dateRv) {
	DateRv = dateRv;
}
public String getEtatest() {
	return Etatest;
}
public void setEtatest(String etatest) {
	Etatest = etatest;
}
public String getGouvernerat() {
	return Gouvernerat;
}
public void setGouvernerat(String gouvernerat) {
	Gouvernerat = gouvernerat;
}
public String getNomHopital() {
	return NomHopital;
}
public void setNomHopital(String nomHopital) {
	NomHopital = nomHopital;
}
public String getNomedecin() {
	return nomedecin;
}
public void setNomedecin(String nomedecin) {
	this.nomedecin = nomedecin;
}
public String getNompatient() {
	return nompatient;
}
public void setNompatient(String nompatient) {
	this.nompatient = nompatient;
}

}
