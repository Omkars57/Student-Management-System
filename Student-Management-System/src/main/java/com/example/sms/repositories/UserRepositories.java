package com.example.sms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sms.entity.User;

public interface UserRepositories extends JpaRepository<User, Integer> {

	public int countByUsernameAndPassword(String username, String password);
}
