package com.StockApp.User;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {

	User findByUsernameAndPassword(String username, String password);

	User findByUsername(String username);

	User findByEmail(String email);

	User findByUsernameAndEmail(String username, String password);

}


