package ch.remo.chat.controller.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import ch.remo.chat.controller.dao.MessageDao;
import ch.remo.chat.controller.entity.MessageEntity;
import ch.remo.chat.controller.model.Message;
import ch.remo.chat.controller.model.User;
import ch.remo.chat.exception.MessageNotValidException;
import ch.remo.chat.exception.UserNotValidException;

@Service
public class MessageService {
	@Autowired
	MessageDao messageDao;

	public List<Message> getAll() {
		return toModel(messageDao.getAll());
	}
	
	public Message insertMessage(Message message) throws MessageNotValidException {
		checkIfMessageIsValid(message);
		return toModel(messageDao.save(toEntity(message)));
	}
	
	public Message updateMessage(Long messageId, Message message) throws MessageNotValidException {
		if(messageId == null || messageId <= 0) {
			throw new MessageNotValidException("Message didn't Exists");
		}
		message.setId(messageId);
		return toModel(messageDao.save(toEntity(message)));
	}
	public void deleteMessage(Long messageId) throws MessageNotValidException {
		if(messageId == null || messageId <= 0) {
			throw new MessageNotValidException("Message didn't Exists");
		}
		try {
		messageDao.delete(messageId);
	}catch (EmptyResultDataAccessException e) {
		
	}
	}
	private void checkIfMessageIsValid(Message message) throws MessageNotValidException {
		if (message == null ) {
			throw new MessageNotValidException("Message can not be Emty");
			
		}
	}
	private MessageEntity toEntity(Message model) {
		MessageEntity entity = new MessageEntity();
		entity.setId(model.getId());
		entity.setMessage(model.getMessage());
		return entity;
	}
	
	private Message toModel(MessageEntity entity) {
		Message model = new Message();
		model.setId(entity.getId());
		model.setMessage(entity.getMessage());
		return model;
	}
	
	private List<Message> toModel(List<MessageEntity> entities){
		List<Message> models = new ArrayList<>();
		for(MessageEntity entity : entities) {
			models.add(toModel(entity));
		}
		return models;
	}

	





}
