package com.moetez.employees.service;

import com.moetez.employees.entities.Role;
import com.moetez.employees.entities.User;

public interface UserService {
void deleteAllusers();
void deleteAllRoles();
User saveUser(User user);
User findUserByUsername (String username);
Role addRole(Role role);
User addRoleToUser(String username, String rolename);
}
