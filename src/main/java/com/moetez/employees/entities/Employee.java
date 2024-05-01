package com.moetez.employees.entities;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idEmployee;
	private String nomEmployee;
	private Double salaire;
	private Date dateEmbauche;
	@ManyToOne
	private Departement departement;
	public Employee() {
		super();
	}
	
	public Employee(String nomEmployee, Double salaire, Date dateEmbauche) {
		super();
		this.nomEmployee = nomEmployee;
		this.salaire = salaire;
		this.dateEmbauche = dateEmbauche;
	}

	@Override
	public String toString() {
		return "Employee [idEmployee=" + idEmployee + ", nomEmployee=" + nomEmployee + ", salaire=" + salaire
				+ ", dateEmbauche=" + dateEmbauche + "]";
	}

	public long getIdEmployee() {
		return idEmployee;
	}
	public void setIdEmployee(long idEmployee) {
		this.idEmployee = idEmployee;
	}
	public String getNomEmployee() {
		return nomEmployee;
	}
	public void setNomEmployee(String nomEmployee) {
		this.nomEmployee = nomEmployee;
	}
	public Double getSalaire() {
		return salaire;
	}
	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}
	public Date getDateEmbauche() {
		return dateEmbauche;
	}
	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	
}
