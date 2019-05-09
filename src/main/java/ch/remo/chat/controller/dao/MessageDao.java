package ch.remo.chat.controller.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.remo.chat.controller.entity.MessageEntity;
import ch.remo.chat.controller.repository.MessageRepository;

@Service
public class MessageDao {

	@Autowired
	MessageRepository messageRepository;
	
	public List<MessageEntity> getAll(){
		return messageRepository.findAll();
	}

	public MessageEntity save(MessageEntity entity) {
		return messageRepository.save(entity);
	}

	public void delete(long messageId) {
		messageRepository.deleteById(messageId);
	}
}
