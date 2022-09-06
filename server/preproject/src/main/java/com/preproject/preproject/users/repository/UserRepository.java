package com.preproject.preproject.users.repository;

import com.preproject.preproject.users.entity.Users;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    @EntityGraph(attributePaths = "roles")
    Optional<Users> findByEmail(String email);
}
