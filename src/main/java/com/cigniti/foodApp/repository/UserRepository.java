package com.cigniti.foodApp.repository;

import com.cigniti.foodApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUserName(String userName);

	List<User> findAllByEmailAndPassword(String email, String password);


	@Transactional
	@Modifying
	@Query("UPDATE User u SET u.status = 'inactive' WHERE u.userId = :userId")
	void deleteUser(@RequestParam("userId") int userId);

}
