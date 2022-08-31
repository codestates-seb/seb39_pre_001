package com.preproject.preproject.users.repository;

import com.preproject.preproject.users.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
