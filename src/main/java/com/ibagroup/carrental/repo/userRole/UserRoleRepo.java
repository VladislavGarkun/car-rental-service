package com.ibagroup.carrental.repo.userRole;


import com.ibagroup.carrental.model.userRole.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRoleRepo extends JpaRepository<UserRole, Long> {

    @Query(value = "select r from UserRole r where r.role = :role")
    UserRole findUserRoleByRole(String role);

}
