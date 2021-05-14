/**
 * 
 */
package com.devs4j.user.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devs4j.user.model.User;
import com.devs4j.user.services.UserServices;

/**
 * @author jpr6a
 *
 */

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserServices userServices;
	
	@GetMapping
	//Metodo Http + Recurso  = Handler methods
	public ResponseEntity<List<User>> get(@RequestParam(value = "startWith", required = false) String startWith){
		return new ResponseEntity<List<User>>(userServices.getUsers(startWith), HttpStatus.OK);
	}
	
	@GetMapping(value ="/{username}")
	public ResponseEntity<User> getUserByUserName(@PathVariable("username") String username){
		return new ResponseEntity<User>(userServices.getUserByUserNAME(username), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		return new ResponseEntity<User>(userServices.createUser(user), HttpStatus.CREATED);
	}
	
	@PutMapping(value="/{username}")
	public ResponseEntity<User> updateUser(@PathVariable ("username") String username, @RequestBody User user){
		return new ResponseEntity<User>(userServices.updateUser(user, username),HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{username}")
	public ResponseEntity<Void> deleteUser(@PathVariable ("username") String username){
		userServices.deleteUser(username);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
