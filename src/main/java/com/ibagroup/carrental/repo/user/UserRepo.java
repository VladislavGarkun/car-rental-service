package com.ibagroup.carrental.repo.user;

import com.ibagroup.carrental.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, Long> {

    @Query(value = "select u from User u where u.userName = :userName")
    User findByUserName(String userName);

    @Query(value = "select u from User u where u.email = :email")
    User findByEmail(String email);
}
