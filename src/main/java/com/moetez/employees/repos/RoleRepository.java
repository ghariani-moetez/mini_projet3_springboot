package com.moetez.employees.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.moetez.employees.entities.Role;
public interface RoleRepository extends JpaRepository<Role, Long> {
Role findByRole(String role);
}
