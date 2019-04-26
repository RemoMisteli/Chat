package ch.remo.chat.controller.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.remo.chat.controller.entity.UserEntity;

import ch.remo.chat.controller.repository.UserRepository;
@Service
public class UserDao {
	@Autowired
	UserRepository userRepository;

	public List<UserEntity> getAll(){
		return userRepository.findAll();
	}

	

	public UserEntity save(UserEntity entity) {
		
		return userRepository.save(entity);
	}



	public void delete(Long userId) {
		//userRepository.delete(entity);
		userRepository.deleteById(userId);
	}



	

	
}
