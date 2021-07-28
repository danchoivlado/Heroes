package com.example.heroes.data.repositories;

import com.example.heroes.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsUserByUsername(String username);
    boolean existsUserByUsernameAndPassword(String username, String password);
    User findUserByUsernameAndPassword(String usename, String password);
}
