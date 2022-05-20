package com.cigniti.foodApp.controller;

import com.cigniti.foodApp.entity.AuthenticationRequest;
import com.cigniti.foodApp.entity.User;
import com.cigniti.foodApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;


@CrossOrigin(origins = "http://20.219.35.173:3000")
@RestController

@RequestMapping("/users")
public class UserController {
	
	

	@Autowired
	UserService userService;

	

	@GetMapping("/list")
	public List<User> getAllUsers() {
		List<User> users = userService.findAll();

		Iterator<User> it = users.iterator();
		while (it.hasNext()) {
			if (it.next().getStatus().equals("inactive")) {
				it.remove();
			}
		}
		return users;

	}

	/*@PostMapping("/save")
	public User saveUser(@RequestBody User user) {

		user.setStatus("active");
		userService.save(user);

		return user;
	}*/

	@PostMapping("/login")
	public User validateUser(@RequestBody AuthenticationRequest authenticationRequest) {
		List<User> users = userService.findByEmailAndPassword(authenticationRequest.getEmail(), authenticationRequest.getPassword());
		if(users.isEmpty())
			throw new RuntimeException("User doesn't exist " + authenticationRequest.getEmail());
		return users.get(0);
	}

	@PostMapping("/register")
	public User saveUser(@RequestBody User user) {
		user.setFirstName("");
		user.setLastName("");
		user.setEmail("");
		user.setPassword("");
		user.setPhoneNumber("");
		user.setRestId(1);
		user.setStatus("active");
		userService.save(user);
		return user;
	}


	@PostMapping("/guestLogin")
	public User saveGuestUser(@RequestBody User user) {
		user.setFirstName(user.getUserName());
		user.setStatus("Active");
		user.setRestId(1);
		userService.saveGuestUser(user);
		return user;
	}

	@PutMapping("/edit")
	public User updateUser(@RequestBody User user) {
		userService.save(user);

		return user;
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {

		User user = userService.findByUserId(id);
		if (user == null) {
			throw new RuntimeException("UserId not found " + id);
		}

		userService.deleteByUserId(id);
		return "Deleted UserId :" + id;
	}

}

/*
 * @GetMapping("/loginPage") public String loginPage() { return
 * "/employees/loginPage"; }
 */

/*
 * @GetMapping("/showFormForAdd") public String showFormForAdd(Model model) {
 * 
 * Employee employee = new Employee(); model.addAttribute("EMPLOYEE", employee);
 * 
 * return "employees/empForm";}
 * 
 * @GetMapping("/showFormForUpdate") public String
 * showFormForUpdate(@RequestParam("employeeId") int id, Model model) { Employee
 * employee = empService.findByEmpId(id); model.addAttribute("EMPLOYEE",
 * employee); return "employees/empForm"; }
 */
