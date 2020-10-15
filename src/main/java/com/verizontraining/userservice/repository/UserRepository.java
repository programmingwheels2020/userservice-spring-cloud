package com.verizontraining.userservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizontraining.userservice.models.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findByEmail(String email);

}
