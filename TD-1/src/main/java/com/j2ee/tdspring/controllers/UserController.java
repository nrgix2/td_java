package com.j2ee.tdspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.j2ee.tdspring.entities.User;
import com.j2ee.tdspring.services.UserService;

import antlr.collections.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class UserController {
	
				@Autowired
		private UserService userService;
				
				@RequestMapping(path = "/add-test-user", method = RequestMethod.GET)
				public void addTestUser() {
				User user = new User();
				user.setUsername("jptest");
				user.setFirstname("Jean Pierre");
				user.setLastname("Test");
				user.setTelephone(0610203040);
				userService.createOrUpdate(user);
				}
				
				@RequestMapping(path = "/user", method = RequestMethod.GET)
				public User getUser(@RequestParam(value = "id") String username) {
				return userService.getUserById(username);
				}
				
				@Operation(summary = "Création ou mise à jour d'un utilisateur")
				@RequestMapping(path = "/user", method = RequestMethod.PUT)
				public void addOrUpdateUser(@RequestBody String username, String firstname, String lastname, int telephone) {
					 userService.addOrUpdateUser(username, firstname, lastname, telephone);
			
				}
				
				@Operation(summary = "Récupération de tous les utilisateurs")
				@RequestMapping(path = "/users/all", method = RequestMethod.GET)
				public java.util.List<User> getUsers() {
					return userService.getAllUsers();
				}
				
				@Operation(summary = "Suppression d'un utilisateur à partir de son identifiant")
						@RequestMapping(path = "/user", method = RequestMethod.DELETE)
						public void deleteUser(@RequestParam(value = "username") String username) {
					userService.deleteUser(username);
					}
	}
