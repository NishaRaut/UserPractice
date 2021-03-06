package com.bridgelabz.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.user.dto.RegistrationDto;
import com.bridgelabz.user.model.User;
@Repository
public interface UserRepository  extends JpaRepository<User ,Long > {
	Optional<User> findByEmail(String email);
}
