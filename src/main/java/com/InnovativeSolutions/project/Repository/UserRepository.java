package com.InnovativeSolutions.project.Repository;

import com.InnovativeSolutions.project.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsernameOrEmail(String email , String username);

    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
