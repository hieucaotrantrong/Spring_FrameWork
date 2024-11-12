package com.example.demo_database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_database.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByusername(String username);
}
