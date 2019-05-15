package ch.remo.chat.controller.service;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import ch.remo.chat.controller.dao.MessageDao;
import ch.remo.chat.controller.entity.MessageEntity;
import ch.remo.chat.controller.model.Message;
import ch.remo.chat.exception.MessageNotValidException;

@Service
public class MessageService {
	@Autowired
	MessageDao messageDao;

	public List<Message> getAll() {
		return toModel(messageDao.getAll());
	}

	public Message insertContent(Message message) {
		return toModel(messageDao.save(toEntity(message)));
		}

	public Message updateContent(Long messageId, Message message) throws MessageNotValidException {
		checkIfMessageIsValid(messageId);

		message.setId(messageId);
		return toModel(messageDao.save(toEntity(message)));
	}

	public void deleteContent(Long messageId) throws MessageNotValidException {
		checkIfMessageIsValid(messageId);
		try {
			messageDao.delete(messageId);
		} catch (EmptyResultDataAccessException e) {
			Logger.getLogger(this.getClass()).error("Error while deleting message", e);
		}
	}

	private void checkIfMessageIsValid(Long messageId) throws MessageNotValidException {
		if (messageId == null || messageId <= 0) {
			throw new MessageNotValidException("Message didn't Exists");
		}
	}

	public MessageEntity toEntity(Message model) {
		if (model == null ) {
			return null;
		}

		MessageEntity entity = new MessageEntity();
		entity.setId(model.getId());
		entity.setContent(model.getContent());
		
		return entity;
	}

	public Message toModel(MessageEntity entity) {


		if (entity == null) {

			return null;
		}
		Message model = new Message();
		model.setId(entity.getId());
		model.setContent(entity.getContent());
		
		return model;
	}

	public List<Message> toModel(List<MessageEntity> entities) {
		if (entities == null ) {
			return new ArrayList<>();
		}
		List<Message> models = new ArrayList<>();
		for (MessageEntity entity : entities) {
			models.add(toModel(entity));
		}
		return models;
	}
}
