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
@Table(name="user")
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="mdp")
	private String mdp;
	
	@Column(name="roler")
	private String roler;
	
//	@OneToMany(mappedBy="user")
//	private List<Patient> patients;
//	
//	@OneToMany(mappedBy="user")
//	private List<Medecin> medecins;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(long id, String email, String mdp, String role) {
		super();
		this.id = id;
		this.email = email;
		this.mdp = mdp;
		this.roler = role;
	}





	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}


	public String getRoler() {
		return roler;
	}


	public void setRoler(String roler) {
		this.roler = roler;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((mdp == null) ? 0 : mdp.hashCode());
		result = prime * result + ((roler == null) ? 0 : roler.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (mdp == null) {
			if (other.mdp != null)
				return false;
		} else if (!mdp.equals(other.mdp))
			return false;
		if (roler == null) {
			if (other.roler != null)
				return false;
		} else if (!roler.equals(other.roler))
			return false;
		return true;
	}


	

	
	
}
