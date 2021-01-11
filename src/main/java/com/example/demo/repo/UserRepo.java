package com.example.demo.repo;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * <b>User Repository</b>
 *
 * @author sejinpark
 * @since 21. 1. 11.
 */
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
