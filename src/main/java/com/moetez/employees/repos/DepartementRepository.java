package com.moetez.employees.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moetez.employees.entities.Departement;

public interface DepartementRepository extends JpaRepository<Departement, Long>  {

}
