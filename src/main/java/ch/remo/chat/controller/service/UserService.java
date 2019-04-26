package ch.remo.chat.controller.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import ch.remo.chat.controller.dao.UserDao;
import ch.remo.chat.controller.entity.UserEntity;

import ch.remo.chat.controller.model.User;
import ch.remo.chat.exception.UserNotValidException;

@Service

public class UserService {
	@Autowired
	UserDao userDao;

	public List<User> getAll() {

		return toModel(userDao.getAll());
	}

	public User insertUser(User user) throws UserNotValidException {
		checkIfUserIsValid(user);
		return toModel(userDao.save(toEntity(user)));
	}
	public User updateUser(Long userId, User user) throws UserNotValidException {
		if (userId == null || userId <= 0) {
			throw new UserNotValidException("User didn't Exists");
		}
		checkIfUserIsValid(user);
		user.setId(userId);
		return toModel(userDao.save(toEntity(user)));
	}

	public void deleteUser(Long userId) throws UserNotValidException {
		if (userId == null || userId <= 0) {
			throw new UserNotValidException("User didn't Exists");
		}
		try {
			userDao.delete(userId);
		}catch (EmptyResultDataAccessException e) {
			
		}
	}

	private void checkIfUserIsValid(User user) throws UserNotValidException {
		if (user == null || StringUtils.isEmpty(user.getPassword()) || StringUtils.isEmpty(user.getUser())) {
			throw new UserNotValidException("Username and Password can not be empty!");
			
		}
	}

	private UserEntity toEntity(User model) {

		UserEntity entity = new UserEntity();
		entity.setId(model.getId());
		entity.setUser(model.getUser());
		entity.setPassword(model.getPassword());
		return entity;
	}

	private User toModel(UserEntity entity) {

		User model = new User();
		model.setId(entity.getId());
		model.setUser(entity.getUser());
		model.setPassword(entity.getPassword());

		return model;
	}

	private List<User> toModel(List<UserEntity> entities) {

		List<User> models = new ArrayList<>();
		for (UserEntity entity : entities) {
			models.add(toModel(entity));
		}
		return models;
	}



}
