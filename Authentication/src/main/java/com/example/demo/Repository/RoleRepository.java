package com.example.demo.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.ERole;
import com.example.demo.models.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {
	  Optional<Role> findByName(ERole name);
	}
