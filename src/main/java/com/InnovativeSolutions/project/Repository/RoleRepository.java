package com.InnovativeSolutions.project.Repository;

import com.InnovativeSolutions.project.Model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Roles,Long> {

    Optional<Roles> findByName(String name);
}
