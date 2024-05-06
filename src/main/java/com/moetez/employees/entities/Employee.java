package com.moetez.employees.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idEmployee;
	@NotNull
	@Size (min = 4,max = 15)
	private String nomEmployee;
	@Min(value = 10)
	 @Max(value = 10000)
	private Double salaire;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
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
