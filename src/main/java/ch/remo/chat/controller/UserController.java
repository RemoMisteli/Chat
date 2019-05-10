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
import io.swagger.annotations.ApiOperation;


@RestController(value = "users")
@RequestMapping("users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@ApiOperation(value = "/users", response = User.class,responseContainer="List", tags="User API")
	@GetMapping(path = "")
	public List<User> getUsers() {
		return userService.getAll();
	}
	
	@ApiOperation(value = "/users", response = User.class, tags="User API")
	@PostMapping(path = "")
	public User insertUser(@RequestBody User user) throws UserNotValidException {
		return userService.insertUser(user);
	}
	
	@ApiOperation(value = "/users/{id}", response = User.class, tags="User API")
	@PutMapping(path = "/{id}")
	public User updateUser(@RequestBody User user,@PathVariable("id") Long userId) throws UserNotValidException {
		return userService.updateUser(userId,user);
	}
	
	@ApiOperation(value = "/users/{id}", tags="User API")
	@DeleteMapping(path ="/{id}")
	public void deleteUser(@PathVariable("id") Long userId) throws UserNotValidException {
		userService.deleteUser(userId);
	}
}
