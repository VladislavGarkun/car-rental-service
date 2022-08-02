package com.bsuir.carrental.dao.repository.userRole;

import com.bsuir.carrental.dao.model.userRole.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    UserRole findUserRoleByRole(String role);

}