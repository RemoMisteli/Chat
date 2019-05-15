package ch.remo.chat.controller.service;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import ch.remo.chat.controller.dao.MessageDao;
import ch.remo.chat.controller.dao.UserDao;
import ch.remo.chat.controller.entity.UserEntity;
import ch.remo.chat.controller.model.User;
import ch.remo.chat.exception.UserNotValidException;

@Service
public class UserService {
	@Autowired
	UserDao userDao;

	@Autowired
	MessageDao messageDao;

	@Autowired
	MessageService messageService;

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
		} catch (EmptyResultDataAccessException e) {
			Logger.getLogger(this.getClass()).error("Error while deleting user", e);
		}
	}

	public void checkIfUserIsValid(User user) throws UserNotValidException {
		if (user == null || StringUtils.isEmpty(user.getPassword()) || StringUtils.isEmpty(user.getUsername())) {
			throw new UserNotValidException("Username and Password can not be empty!");
		}
	}

	public UserEntity toEntity(User model) {
		if (model == null) {
			return null;
		}
		UserEntity entity = new UserEntity();
		entity.setId(model.getId());
		entity.setUsername(model.getUsername());
		entity.setPassword(model.getPassword());
		return entity;
	}

	public User toModel(UserEntity entity) {
		
		if (entity == null ) {
			return null;
		}
		User model = new User();
		model.setId(entity.getId());
		model.setUsername(entity.getUsername());
		model.setPassword(entity.getPassword());
		model.setSentMessages(messageService.toModel(entity.getSentMessages()));
		model.setSentMessages(messageService.toModel(entity.getSentMessages()));
		model.setReceivedMessages(messageService.toModel(entity.getReceivedMessages()));
		return model;
	}

	public List<User> toModel(List<UserEntity> entities) {
		List<User> models = new ArrayList<>();
		for (UserEntity entity : entities) {
			models.add(toModel(entity));
		}
		return models;
	}

}
