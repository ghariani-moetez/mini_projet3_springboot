package com.moetez.employees.repos;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.moetez.employees.entities.Departement;
import com.moetez.employees.entities.Employee;

@RepositoryRestResource(path = "rest")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	List<Employee> findByNomEmployee(String nom);
	List<Employee> findByNomEmployeeContains(String nom); 
	
	//@Query("select p from Employee p where p.nomEmployee like %?1 and p.salaire > ?2")
	//List<Employee> findByNomSalaire (String nom, Double salaire);
	
	@Query("select p from Employee p where p.nomEmployee like %:nom and p.salaire > :salaire")
	List<Employee> findByNomSalaire (@Param("nom") String nom,@Param("salaire") Double salaire);
	
	@Query("select p from Employee p where p.departement = ?1")
	List<Employee> findByDepartement(Departement departement);

	List<Employee> findByDepartementIdDep(Long id);
	
	List<Employee> findByOrderByNomEmployeeAsc();
	
	@Query("select p from Employee p order by p.nomEmployee ASC, p.salaire DESC")
	List<Employee> trierEmployeesNomsSalaire ();

}
