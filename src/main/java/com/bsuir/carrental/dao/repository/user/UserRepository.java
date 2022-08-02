package com.bsuir.carrental.dao.repository.user;

import com.bsuir.carrental.dao.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUserName(String userName);

    User findUserByEmail(String email);

}