package com.seethec.api.entity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTableRepository extends JpaRepository<UserTable, Integer>{
	
	Optional<UserTable> findByUsername(String username);
}
