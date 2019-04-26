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

import ch.remo.chat.controller.model.Message;
import ch.remo.chat.controller.service.MessageService;
import ch.remo.chat.exception.MessageNotValidException;

@RestController(value = "chat")
@RequestMapping("chat")
public class MessageController {
	
	@Autowired
	MessageService messageService;

	@GetMapping(path = "/messages")
	public List<Message> getMessages() {
		return messageService.getAll();
	}
	
	@PostMapping(path = "/messages")
	public Message insertMessage(@RequestBody Message message) throws MessageNotValidException {
		return messageService.insertMessage(message);
	}
	
	@PutMapping(path = "/messages/{id}")//if id dosn't exist it will be create a new message
	public Message updateMessage(@RequestBody Message message,@PathVariable("id") Long messageId) throws MessageNotValidException {
		return messageService.updateMessage(messageId,message);
	}
	
	@DeleteMapping(path ="/messages/{id}")
	public void deleteMessage(@PathVariable("id") Long messageId) throws MessageNotValidException {
		messageService.deleteMessage(messageId);
		
	}
}
