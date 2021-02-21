package com.esprit.covid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esprit.covid.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
