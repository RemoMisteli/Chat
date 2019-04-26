package ch.remo.chat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.remo.chat.controller.model.User;
import ch.remo.chat.controller.service.UserService;
import ch.remo.chat.exception.UserNotValidException;
@RestController(value = "users")
@RequestMapping("users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(path = "/users")
	public List<User> getUsers() {
		return userService.getAll();
	}
	
	@PostMapping(path = "/users")
	public User insertUser(@RequestBody User user) throws UserNotValidException {
		return userService.insertUser(user);
	}
	
	@PutMapping(path = "/users/{id}")
	public User updateUser(@RequestBody User user,@PathVariable("id") Long userId) throws UserNotValidException {
		return userService.updateUser(userId,user);//password?
	}
	
	@DeleteMapping(path ="/users/{id}")
	public void deleteUser(@PathVariable("id") Long userId) throws UserNotValidException {
		userService.deleteUser(userId);
	}
}
